package com.example.ysm.demozhihu.widget;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;

/**
 * Created by Administrator on 2016/6/1.
 */
public class MySwipeRefreshLayout extends SwipeRefreshLayout
{

    private GestureDetector detector;

    public MySwipeRefreshLayout(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        detector = new GestureDetector(context, new GestureDetector.OnGestureListener()
        {
            @Override
            public boolean onDown(MotionEvent e)
            {
                return false;
            }

            @Override
            public void onShowPress(MotionEvent e)
            {

            }

            @Override
            public boolean onSingleTapUp(MotionEvent e)
            {
                return false;
            }

            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY)
            {
                if (Math.abs(distanceX) > Math.abs(distanceY)/2) return false;
                return true;
            }

            @Override
            public void onLongPress(MotionEvent e)
            {

            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY)
            {
                return false;
            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev)
    {
        return super.onInterceptTouchEvent(ev) && detector.onTouchEvent(ev);
    }
}
