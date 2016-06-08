package com.example.ysm.demozhihu.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/2.
 */
public class HomeNews
{

    /**
     * date : 20160602
     * stories : [{"images":["http://pic2.zhimg.com/740a567e6364ce1846449ecad6a468e5.jpg"],"type":0,"id":8384820,"ga_prefix":"060209","title":"那场推翻种族隔离的伟大事件过后，有位「第一夫人」被遗忘了"},{"images":["http://pic2.zhimg.com/0b08d857aa91aa7f57895bb325d34251.jpg"],"type":0,"id":8388468,"ga_prefix":"060208","title":"练跆拳道的女生有多厉害？真的可以踢碎砖头吗？"},{"images":["http://pic1.zhimg.com/cca3d2ccc65088f85a61ebab676d331c.jpg"],"type":0,"id":8390232,"ga_prefix":"060207","title":"两个卵子也能繁殖后代，雄性多余了吗？"},{"images":["http://pic4.zhimg.com/481d90b18104c72dab9df94a401398f3.jpg"],"type":0,"id":8376632,"ga_prefix":"060207","title":"关于儿童节，一个并不愉快的故事"},{"images":["http://pic4.zhimg.com/49b09a27632e03513aae4beec26bc157.jpg"],"type":0,"id":8388980,"ga_prefix":"060207","title":"「这是欧盟说的啊？那我就信了」"},{"images":["http://pic3.zhimg.com/caf0a88ff2626265404c1947440b982e.jpg"],"type":0,"id":8390211,"ga_prefix":"060207","title":"读读日报 24 小时热门 TOP 5 · 我曾经跟陈冠希认真地聊了 4、5 个钟头"},{"images":["http://pic1.zhimg.com/ffc8af23db512b3aecb507e38bc79440.jpg"],"type":0,"id":8382789,"ga_prefix":"060206","title":"瞎扯 · 如何正确地吐槽"}]
     * top_stories : [{"image":"http://pic2.zhimg.com/7740095fd836c2a307414ab38e86e861.jpg","type":0,"id":8390211,"ga_prefix":"060207","title":"读读日报 24 小时热门 TOP 5 · 我曾经跟陈冠希认真地聊了 4、5 个钟头"},{"image":"http://pic2.zhimg.com/9b83a5ee5416f6257d51e3118cb4f4f1.jpg","type":0,"id":8376632,"ga_prefix":"060207","title":"关于儿童节，一个并不愉快的故事"},{"image":"http://pic1.zhimg.com/d3b732cae295a563e5002c6c6f5531e8.jpg","type":0,"id":8387810,"ga_prefix":"060119","title":"在六月这个「骄傲月」，聊聊性与性别"},{"image":"http://pic4.zhimg.com/80e38fc631d7f1956660d1b50ca4ae9b.jpg","type":0,"id":8383075,"ga_prefix":"060115","title":"《进击的巨人》中优秀的新兵反而被分配去安全的团中，合理吗？"},{"image":"http://pic4.zhimg.com/a38c31e6dfc87a8bd7b288d50e08dc17.jpg","type":0,"id":8385108,"ga_prefix":"060107","title":"读读日报 24 小时热门 TOP 5 · 把童年的动漫金曲串烧着弹了一遍"}]
     */

    private String date;
    /**
     * images : ["http://pic2.zhimg.com/740a567e6364ce1846449ecad6a468e5.jpg"]
     * type : 0
     * id : 8384820
     * ga_prefix : 060209
     * title : 那场推翻种族隔离的伟大事件过后，有位「第一夫人」被遗忘了
     */

    private List<StoriesBean> stories;
    /**
     * image : http://pic2.zhimg.com/7740095fd836c2a307414ab38e86e861.jpg
     * type : 0
     * id : 8390211
     * ga_prefix : 060207
     * title : 读读日报 24 小时热门 TOP 5 · 我曾经跟陈冠希认真地聊了 4、5 个钟头
     */

    private List<TopStoriesBean> top_stories;

    public static HomeNews objectFromData(String str)
    {

        return new Gson().fromJson(str, HomeNews.class);
    }

    public static HomeNews objectFromData(String str, String key)
    {

        try
        {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(key), HomeNews.class);
        } catch (JSONException e)
        {
            e.printStackTrace();
        }

        return null;
    }

    public static List<HomeNews> arrayHomeNewsFromData(String str)
    {

        Type listType = new TypeToken<ArrayList<HomeNews>>()
        {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<HomeNews> arrayHomeNewsFromData(String str, String key)
    {

        try
        {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<HomeNews>>()
            {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(key), listType);

        } catch (JSONException e)
        {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public String getDate()
    {
        return date;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    public List<StoriesBean> getStories()
    {
        return stories;
    }

    public void setStories(List<StoriesBean> stories)
    {
        this.stories = stories;
    }

    public List<TopStoriesBean> getTop_stories()
    {
        return top_stories;
    }

    public void setTop_stories(List<TopStoriesBean> top_stories)
    {
        this.top_stories = top_stories;
    }

    public static class StoriesBean
    {
        private int id;
        private String title;
        private List<String> images;

        public static StoriesBean objectFromData(String str)
        {

            return new Gson().fromJson(str, StoriesBean.class);
        }

        public static StoriesBean objectFromData(String str, String key)
        {

            try
            {
                JSONObject jsonObject = new JSONObject(str);

                return new Gson().fromJson(jsonObject.getString(key), StoriesBean.class);
            } catch (JSONException e)
            {
                e.printStackTrace();
            }

            return null;
        }

        public static List<StoriesBean> arrayStoriesBeanFromData(String str)
        {

            Type listType = new TypeToken<ArrayList<StoriesBean>>()
            {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public static List<StoriesBean> arrayStoriesBeanFromData(String str, String key)
        {

            try
            {
                JSONObject jsonObject = new JSONObject(str);
                Type listType = new TypeToken<ArrayList<StoriesBean>>()
                {
                }.getType();

                return new Gson().fromJson(jsonObject.getString(key), listType);

            } catch (JSONException e)
            {
                e.printStackTrace();
            }

            return new ArrayList();


        }

        public int getId()
        {
            return id;
        }

        public void setId(int id)
        {
            this.id = id;
        }

        public String getTitle()
        {
            return title;
        }

        public void setTitle(String title)
        {
            this.title = title;
        }

        public List<String> getImages()
        {
            return images;
        }

        public void setImages(List<String> images)
        {
            this.images = images;
        }
    }

    public static class TopStoriesBean
    {
        private String image;
        private int id;
        private String title;

        public static TopStoriesBean objectFromData(String str)
        {

            return new Gson().fromJson(str, TopStoriesBean.class);
        }

        public static TopStoriesBean objectFromData(String str, String key)
        {

            try
            {
                JSONObject jsonObject = new JSONObject(str);

                return new Gson().fromJson(jsonObject.getString(key), TopStoriesBean.class);
            } catch (JSONException e)
            {
                e.printStackTrace();
            }

            return null;
        }

        public static List<TopStoriesBean> arrayTopStoriesBeanFromData(String str)
        {

            Type listType = new TypeToken<ArrayList<TopStoriesBean>>()
            {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public static List<TopStoriesBean> arrayTopStoriesBeanFromData(String str, String key)
        {

            try
            {
                JSONObject jsonObject = new JSONObject(str);
                Type listType = new TypeToken<ArrayList<TopStoriesBean>>()
                {
                }.getType();

                return new Gson().fromJson(jsonObject.getString(key), listType);

            } catch (JSONException e)
            {
                e.printStackTrace();
            }

            return new ArrayList();


        }

        public String getImage()
        {
            return image;
        }

        public void setImage(String image)
        {
            this.image = image;
        }

        public int getId()
        {
            return id;
        }

        public void setId(int id)
        {
            this.id = id;
        }

        public String getTitle()
        {
            return title;
        }

        public void setTitle(String title)
        {
            this.title = title;
        }
    }
}
