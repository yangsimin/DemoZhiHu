package com.example.ysm.demozhihu.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ysm.demozhihu.R;
import com.example.ysm.demozhihu.activity.NewsDetailActivity;
import com.example.ysm.demozhihu.bean.HomeNews;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 2016/6/2.
 */
public class HomeLvAdapter extends BaseAdapter
{
    private Context context;

    private HomeNews homeNews;

    private List<HomeNews.StoriesBean> stories;

    public HomeLvAdapter(Context context, HomeNews homeNews)
    {
        this.context = context;
        this.homeNews = homeNews;
    }

    public HomeLvAdapter(Context context, List<HomeNews.StoriesBean> stories)
    {
        this.context = context;
        this.stories = stories;
    }

    @Override
    public int getCount()
    {
        return stories.size();
    }

    @Override
    public Object getItem(int position)
    {
        return stories.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        ViewHold viewHold;
        if (convertView == null)
        {
            convertView = LayoutInflater.from(context).inflate(R.layout.adapter_home_lv_item, parent, false);
            viewHold = new ViewHold();
            viewHold.tvSort = (TextView) convertView.findViewById(R.id.lv_sort);
            viewHold.tvTitle = (TextView) convertView.findViewById(R.id.lv_item_title);
            viewHold.ivImage = (ImageView) convertView.findViewById(R.id.lv_item_image);
            convertView.setTag(viewHold);
        }
        viewHold = (ViewHold) convertView.getTag();
        final HomeNews.StoriesBean storiesBean = stories.get(position);
        Picasso.with(context).load(storiesBean.getImages().get(0)).into(viewHold.ivImage);
        viewHold.tvTitle.setText(storiesBean.getTitle());
        if (position == 0) viewHold.tvSort.setVisibility(View.VISIBLE);
        else viewHold.tvSort.setVisibility(View.GONE);

        convertView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(context, NewsDetailActivity.class);
                intent.putExtra("id", storiesBean.getId());
                context.startActivity(intent);
            }
        });
        return convertView;
    }

    private class ViewHold
    {
        ImageView ivImage;
        TextView tvTitle;
        TextView tvSort;
    }
}
