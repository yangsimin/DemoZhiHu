package com.example.ysm.demozhihu.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2016/6/1.
 */
public abstract class BaseFragment extends Fragment
{
    protected View root;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        root = inflater.inflate(getLayout(), container, false);
        return root;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        initViews();
        initData();
        initEvent();
    }

    protected abstract int getLayout();
    protected void initViews(){}
    protected void initData(){}
    protected void initEvent(){}
}
