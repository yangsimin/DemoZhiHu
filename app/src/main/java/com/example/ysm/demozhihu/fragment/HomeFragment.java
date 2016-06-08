package com.example.ysm.demozhihu.fragment;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ysm.demozhihu.R;
import com.example.ysm.demozhihu.activity.NewsDetailActivity;
import com.example.ysm.demozhihu.adapter.HeaderPagerAdapter;
import com.example.ysm.demozhihu.adapter.HomeLvAdapter;
import com.example.ysm.demozhihu.base.LazyLoadFragment;
import com.example.ysm.demozhihu.bean.HomeNews;
import com.example.ysm.demozhihu.utils.Contants;
import com.example.ysm.demozhihu.utils.HttpUtil;
import com.example.ysm.demozhihu.utils.ZhihuTask;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/1.
 */
public class HomeFragment extends LazyLoadFragment
{
    private SwipeRefreshLayout srlRefresh;

    private ListView lvHome;

    private ViewPager vpHeader;

    private LinearLayout llPointGroup;

    private int lastPosition;

    private int[] images = {R.drawable.p1, R.drawable.p2, R.drawable.p3, R.drawable.p4, R.drawable.p5};

    private String[] titles = {
            "读读日报 24 小时热门 TOP 5 · 把童年的动漫金曲串烧着弹了一遍",
            "网红电商火得不要不要的，符合这些条件的才好拿钱",
            "教你在城市里看日出，开启元气满满的一天",
            "离婚后「被负债」300 万，婚姻法的错？",
            "小时候最有趣最好玩的世界乐园，现在变得破败不堪了……"};

    private int[] imageIds = {8385108, 8383133, 8377594, 8381308, 8382410};

    //    private ArrayList<ImageView> imageList;
    private ArrayList<View> views;

    private HomeNews homeNews;

    private List<HomeNews.StoriesBean> stories;
    private HomeLvAdapter homeLvAdapter;

    @Override
    protected int getLayout()
    {
        return R.layout.fragment_home;
    }

    @Override
    protected void initViews()
    {
        srlRefresh = (SwipeRefreshLayout) root.findViewById(R.id.home_srl);
        lvHome = (ListView) root.findViewById(R.id.home_lv);

        setListViewHeader();

    }

    private boolean isRunning = false;
    private Handler handler = new Handler()
    {
        @Override
        public void handleMessage(Message msg)
        {
            if (isRunning)
            {
                vpHeader.setCurrentItem(vpHeader.getCurrentItem() + 1);
                handler.sendEmptyMessageDelayed(0, 3000);
            }
        }
    };

    private void setListViewHeader()
    {
        View header = LayoutInflater.from(getContext()).inflate(R.layout.header_home_lv, null);
        vpHeader = (ViewPager) header.findViewById(R.id.lvheader_vp);
        llPointGroup = (LinearLayout) header.findViewById(R.id.lvheader_rg);

//        imageList = new ArrayList<>();
        views = new ArrayList<>();
        for (int i = 0; i < images.length; i++)
        {
            View view = LayoutInflater.from(getContext()).inflate(R.layout.adapter_vp_item, null);
            ImageView image = (ImageView) view.findViewById(R.id.lvheader_iv);
            TextView title = (TextView) view.findViewById(R.id.lvheader_tv);
            image.setImageResource(images[i]);
            final int id = imageIds[i];
            image.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    Intent intent = new Intent(getActivity(), NewsDetailActivity.class);
                    intent.putExtra("id", id);
                    startActivity(intent);
                }
            });
            title.setText(titles[i]);
            views.add(view);
            //添加点
            ImageView point = new ImageView(getContext());
            point.setId(i);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(12, 12);
            layoutParams.setMargins(3, 0, 3, 0);
            point.setLayoutParams(layoutParams);
            point.setBackgroundResource(R.drawable.selector_vp_point);
            if (i == 0)
            {
                point.setEnabled(true);
            } else point.setEnabled(false);
            llPointGroup.addView(point);
        }
        HeaderPagerAdapter adapter = new HeaderPagerAdapter(views);
        lvHome.addHeaderView(header);
        vpHeader.setAdapter(adapter);

        //设置监听，使图片与点联动
        vpHeader.addOnPageChangeListener(new ViewPager.OnPageChangeListener()
        {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)
            {

            }

            @Override
            public void onPageSelected(int position)
            {
                position = position % images.length;
                llPointGroup.getChildAt(lastPosition).setEnabled(false);
                llPointGroup.getChildAt(position).setEnabled(true);
                lastPosition = position;
            }

            @Override
            public void onPageScrollStateChanged(int state)
            {

            }
        });

        vpHeader.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                switch (event.getAction())
                {
                    case MotionEvent.ACTION_MOVE:
                        srlRefresh.setEnabled(false);
                        break;
                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL:
                        srlRefresh.setEnabled(true);
                        break;
                }
                return false;
            }
        });

        vpHeader.setCurrentItem(Integer.MAX_VALUE / 2 - (Integer.MAX_VALUE / 2) % images.length);

        isRunning = true;
        handler.sendEmptyMessageDelayed(0, 3000);
    }

    @Override
    protected void initData()
    {
        stories = new ArrayList<>();
        homeLvAdapter = new HomeLvAdapter(getContext(), stories);
        lvHome.setAdapter(homeLvAdapter);

        new ZhihuTask(new ZhihuTask.Request()
        {
            @Override
            public Object doRequest()
            {
                return HttpUtil.doGet(Contants.NEWS_LATEST_URL);
            }
        }, new ZhihuTask.RequestCallBack()
        {
            @Override
            public void success(Object object)
            {
                String jsonStr = (String) object;
                try
                {
                    homeNews = HttpUtil.parseJsonToHomeNews(jsonStr);
                } catch (JSONException e)
                {
                    e.printStackTrace();
                }
                stories.addAll(homeNews.getStories());
                homeLvAdapter.notifyDataSetChanged();
            }
        }).execute();
    }

    @Override
    protected void initEvents()
    {
        srlRefresh.setColorSchemeResources(R.color.colorToolBar);
        srlRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener()
        {
            @Override
            public void onRefresh()
            {
                HomeFragment.this.initData();
                srlRefresh.setRefreshing(false);
//                new Handler().postDelayed(new Runnable()
//                {
//                    @Override
//                    public void run()
//                    {
//                        srlRefresh.setRefreshing(false);
//                    }
//                }, 1500);
            }
        });

    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        isRunning = false;
    }
}
