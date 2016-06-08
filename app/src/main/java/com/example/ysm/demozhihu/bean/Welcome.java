package com.example.ysm.demozhihu.bean;

import com.google.gson.Gson;

/**
 * Created by Administrator on 2016/5/30.
 */
public class Welcome
{

    /**
     * text : Luca Zanon
     * img : https://pic1.zhimg.com/df3c363e0d9c555ce29b9d9a51e5973e.jpg
     */

    private String text;
    private String img;

    public static Welcome objectFromData(String str)
    {

        return new Gson().fromJson(str, Welcome.class);
    }

    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }

    public String getImg()
    {
        return img;
    }

    public void setImg(String img)
    {
        this.img = img;
    }
}
