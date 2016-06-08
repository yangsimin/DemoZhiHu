package com.example.ysm.demozhihu.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/6/1.
 */
public class HeaderPagerAdapter extends PagerAdapter
{
    private ArrayList<View> viewList;

    public HeaderPagerAdapter(ArrayList<View> viewList)
    {
        this.viewList = viewList;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position)
    {
        position = position%viewList.size();
        container.addView(viewList.get(position));
        return viewList.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object)
    {
        container.removeView((View) object);
    }

    @Override
    public int getCount()
    {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object)
    {
        return view == object;
    }
}
