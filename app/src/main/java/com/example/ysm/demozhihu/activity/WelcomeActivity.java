package com.example.ysm.demozhihu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ysm.demozhihu.R;

/**
 * Created by Administrator on 2016/5/26.
 */
public class WelcomeActivity extends AppCompatActivity
{
    private Animation animIn, animScale, animOut;

    private ImageView ivPic;

    private TextView tvDes;

    private String data;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        initView();
        initAnim();
//        ivPic.startAnimation(animIn);
        loadData();
        ivPic.setAnimation(animScale);
        setListener();
    }

    private void initView()
    {
        ivPic = (ImageView) findViewById(R.id.welcome_pic_iv);
        tvDes = (TextView) findViewById(R.id.welcome_des_tv);
    }

    private void loadData()
    {
//        WelcomeHttpUtil.requestNewsLatest(new ZhihuTask.RequestCallBack()
//        {
//            @Override
//            public void success(Object object)
//            {
//                data = (String) object;
//            }
//        });
    }

    private void initAnim()
    {
        animIn = AnimationUtils.loadAnimation(this, R.anim.welcome_in);
        animIn.setFillAfter(true);
        animScale = AnimationUtils.loadAnimation(this, R.anim.welcome_scale);
        animScale.setFillAfter(true);
        animOut = AnimationUtils.loadAnimation(this, R.anim.welcome_out);
        animOut.setFillAfter(true);
    }

    private void setListener()
    {
        animIn.setAnimationListener(new Animation.AnimationListener()
        {
            @Override
            public void onAnimationStart(Animation animation)
            {}

            @Override
            public void onAnimationEnd(Animation animation)
            {
                ivPic.startAnimation(animScale);
            }

            @Override
            public void onAnimationRepeat(Animation animation)
            {}
        });

        animScale.setAnimationListener(new Animation.AnimationListener()
        {
            @Override
            public void onAnimationStart(Animation animation)
            {}

            @Override
            public void onAnimationEnd(Animation animation)
            {
                ivPic.startAnimation(animOut);
            }

            @Override
            public void onAnimationRepeat(Animation animation)
            {}
        });

        animOut.setAnimationListener(new Animation.AnimationListener()
        {
            @Override
            public void onAnimationStart(Animation animation)
            {}

            @Override
            public void onAnimationEnd(Animation animation)
            {
                Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
//                if (data != null)
//                {
                    intent.putExtra("data", data);
//                }
                WelcomeActivity.this.startActivity(intent);
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation)
            {}
        });
    }
}
