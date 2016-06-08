package com.example.ysm.demozhihu.activity;

import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.internal.NavigationMenuView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;

import com.example.ysm.demozhihu.R;
import com.example.ysm.demozhihu.fragment.HomeFragment;
import com.example.ysm.demozhihu.widget.CircleImageView;

public class MainActivity extends AppCompatActivity
{
    private Toolbar tbMain;

    private NavigationView nvMain;

    private DrawerLayout dlMain;

    private FrameLayout flContent;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        setBarAndToggle();
        initData();
        initEvent();
    }

    private void initViews()
    {
        tbMain = (Toolbar) findViewById(R.id.main_tb);
        nvMain = (NavigationView) findViewById(R.id.main_nv);
        dlMain = (DrawerLayout) findViewById(R.id.main_dl);
        flContent = (FrameLayout) findViewById(R.id.main_fl);
    }

    private void setBarAndToggle()
    {
        //设置toolbar
        tbMain.setTitle("首页");
        tbMain.setTitleTextColor(Color.WHITE);
        tbMain.setTitleTextAppearance(this, R.style.TitleTextStyle);
        setSupportActionBar(tbMain);

        //设置toggle
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, dlMain, tbMain, 0, 0);
        //初始化
        toggle.syncState();
        dlMain.addDrawerListener(toggle);
        dlMain.setDrawerShadow(R.drawable.shape_drawer_shadow, GravityCompat.START);
    }
    private void initData()
    {
        View headerView = nvMain.getHeaderView(0);
        CircleImageView imageView = (CircleImageView) headerView.findViewById(R.id.header_head_iv);
        imageView.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.headsrc));

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.main_fl, new HomeFragment());
        transaction.commit();
    }

    private void initEvent()
    {
        NavigationMenuView navigationMenuView = (NavigationMenuView) nvMain.getChildAt(0);
        if (navigationMenuView != null) {
            navigationMenuView.setVerticalScrollBarEnabled(false);
        }
    }
}
