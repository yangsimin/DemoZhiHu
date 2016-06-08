package com.example.ysm.demozhihu.activity;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.webkit.WebView;

import com.example.ysm.demozhihu.R;
import com.example.ysm.demozhihu.bean.NewsDetail;
import com.example.ysm.demozhihu.utils.Contants;
import com.example.ysm.demozhihu.utils.HttpUtil;
import com.example.ysm.demozhihu.utils.ZhihuTask;
import com.google.gson.Gson;

/**
 * Created by Administrator on 2016/6/2.
 */
public class NewsDetailActivity extends AppCompatActivity
{
    private WebView wvDetail;

    private Toolbar tbTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        final int id = getIntent().getIntExtra("id", 0);


        wvDetail = (WebView) findViewById(R.id.news_detail_wv);
        tbTitle = (Toolbar) findViewById(R.id.news_detail_tb);

        loadData(id);
        setToolbar();

    }

    private void setToolbar()
    {
        tbTitle.setBackgroundColor(getResources().getColor(R.color.colorToolBar));
        tbTitle.setTitle("");
//        tbTitle.setNavigationIcon(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
        setSupportActionBar(tbTitle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        final Drawable upArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
        upArrow.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);
    }

    private void loadData(final int id)
    {
        new ZhihuTask(new ZhihuTask.Request()
        {
            @Override
            public Object doRequest()
            {
                return HttpUtil.doGet(Contants.NEWS_DETAIL_URL + id);
            }
        }, new ZhihuTask.RequestCallBack()
        {
            @Override
            public void success(Object object)
            {
                Gson gson = new Gson();
                NewsDetail newsDetail = gson.fromJson(object.toString(), NewsDetail.class);
                StringBuilder sb = new StringBuilder();
                sb.append("<div class=\"img-wrap\">")
                        .append("<h1 class=\"headline-title\">")
                        .append(newsDetail.getTitle()).append("</h1>")
                        .append("<span class=\"img-source\">")
                        .append(newsDetail.getImage_source()).append("</span>")
                        .append("<img src=\"").append(newsDetail.getImage())
                        .append("\" alt=\"\">")
                        .append("<div class=\"img-mask\"></div>");
                String mNewsContent = "<link rel=\"stylesheet\" type=\"text/css\" href=\"news_content_style.css\"/>"
                        + "<link rel=\"stylesheet\" type=\"text/css\" href=\"news_header_style.css\"/>"
                        + newsDetail.getBody().replace("<div class=\"img-place-holder\">", sb.toString());
                wvDetail.loadDataWithBaseURL("file:///android_asset/", mNewsContent, null, "utf-8", null);
            }
        }).execute();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if (item.getItemId() == android.R.id.home) onBackPressed();
        return super.onOptionsItemSelected(item);
    }
}
