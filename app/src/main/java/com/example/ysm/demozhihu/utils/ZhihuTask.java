package com.example.ysm.demozhihu.utils;

import android.os.AsyncTask;
import android.util.Log;

/**
 * Created by Administrator on 2016/5/30.
 */
public class ZhihuTask extends AsyncTask<Void, Integer, Object>
{
    private Request request;

    private RequestCallBack callBack;

    public ZhihuTask(Request request, RequestCallBack callBack)
    {
        this.request = request;
        this.callBack = callBack;
    }
    @Override
    protected Object doInBackground(Void... params)
    {
        return request.doRequest();
    }

    @Override
    protected void onPostExecute(Object result)
    {
        if (result != null)
        {
            callBack.success(result);
        }
        else
        {
            Log.d("http", "请求失败！");
        }
    }

    public interface Request
    {
        Object doRequest();
    }

    public interface RequestCallBack
    {
        void success(Object object);
    }
}
