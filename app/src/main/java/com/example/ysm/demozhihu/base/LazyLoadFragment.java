package com.example.ysm.demozhihu.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2016/6/1.
 */
public abstract class LazyLoadFragment extends Fragment
{
    private boolean isInit;

    private boolean isLoaded;

    protected View root;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        if (root == null)
        {
            root = inflater.inflate(getLayout(), container, false);
        }
        return root;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);

        initViews();

        isInit = true;

        lazyLoad();

        initEvents();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser)
    {
        super.setUserVisibleHint(isVisibleToUser);
        lazyLoad();
    }

    private void lazyLoad()
    {
        //如果可见
        if (getUserVisibleHint())
        {
            if (!isLoaded)
            {
                if (root != null)
                {
                    if (isInit)
                    {
                        initData();
                        isLoaded = true;
                    }
                }
            }
        }
    }

    protected abstract int getLayout();

    protected void initData(){}

    protected void initEvents(){}

    protected void initViews(){}
}
