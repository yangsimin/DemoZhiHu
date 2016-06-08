package com.example.ysm.demozhihu.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.example.ysm.demozhihu.bean.HomeNews;
import com.example.ysm.demozhihu.bean.NewsDetail;
import com.google.gson.Gson;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Administrator on 2016/5/29.
 */
public class HttpUtil
{
    public static Object doGet(String httpUrl)
    {
        InputStream inputStream = null;
        InputStreamReader reader = null;
        BufferedReader bufferedReader = null;
        try
        {
            URL url = new URL(httpUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);
            conn.setDoInput(true);
            conn.connect();
            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK)
            {
                inputStream = conn.getInputStream();
                reader = new InputStreamReader(inputStream);
                bufferedReader = new BufferedReader(reader);
                StringBuffer resultBuffer = new StringBuffer();
                String line;
                while ((line = bufferedReader.readLine())!= null)
                {
                    resultBuffer.append(line);
                }
                String result = resultBuffer.toString();
                Log.d("http", "请求成功" + result);
                return result;
            }
        } catch (MalformedURLException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        } finally
        {
            try
            {
                if (inputStream == null)
                {
                  Log.d("http", "请求失败");
                   return null;
                }
                inputStream.close();
                bufferedReader.close();
                reader.close();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }

        return null;
    }
    
    public static Bitmap downLoadBitmap(String imageUrl)
    {
        InputStream inputStream = null;
        try
        {
            URL url = new URL(imageUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);
            conn.setDoInput(true);
            conn.connect();
            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK)
            {
                inputStream = conn.getInputStream();
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);

                Log.d("http", "图片下载成功");
                return bitmap;
            }
        } catch (MalformedURLException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        } finally
        {
            try
            {
                inputStream.close();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }

        Log.d("http", "请求失败！");
        return null;
    }

    public static NewsDetail parseJsonToDetail(String json) throws JSONException
    {
        Gson gson = new Gson();
        return gson.fromJson(json, NewsDetail.class);
    }

    public static HomeNews parseJsonToHomeNews(String json) throws JSONException
    {
        Gson gson = new Gson();
        return gson.fromJson(json, HomeNews.class);
    }
}
