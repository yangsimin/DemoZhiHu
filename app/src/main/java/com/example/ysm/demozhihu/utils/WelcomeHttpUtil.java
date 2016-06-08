package com.example.ysm.demozhihu.utils;

/**
 * Created by Administrator on 2016/5/30.
 */
public class WelcomeHttpUtil
{
    public static void requestNewsLatest(ZhihuTask.RequestCallBack callBack)
    {
        new ZhihuTask(new ZhihuTask.Request()
        {
            @Override
            public Object doRequest()
            {
                return HttpUtil.doGet(Contants.NEWS_LATEST_URL);
            }
        }, callBack).execute();
    }
}
