package com.example.ysm.demozhihu.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/3.
 */
public class NewsDetail
{

    /**
     * body : <div class="main-wrap content-wrap">
     <div class="headline">

     <div class="img-place-holder"></div>



     </div>

     <div class="content-inner">




     <div class="question">
     <h2 class="question-title"></h2>

     <div class="answer">

     <div class="content">
     <p>知乎日报注：认为自己水平不够的，请求助专业人士</p>
     </div>
     </div>


     </div>





     <div class="question">
     <h2 class="question-title">什么程度的水性可以跳下水救溺水者？</h2>

     <div class="answer">

     <div class="meta">
     <img class="avatar" src="http://pic4.zhimg.com/7f3ee8aefdd1edf128ccc84836ecb49b_is.jpg">
     <span class="author">步行者</span>
     </div>

     <div class="content">
     <p>救生员一枚。</p>
     <p>亲手救过一人。用杆子捞起来几十人。</p>
     <p>什么水性可以下水？</p>
     <p>在不考虑水性的情况下，我觉得首先是体型上考虑。比你弱比你瘦的人，你可以下，和你差不多或比你还壮，还是求救吧。体型上无法胜利，你就有了送命的危险。控制不了溺水者，你就可能被他抱住一起溺亡。</p>
     <p>在体型上胜利以后我们来考虑水性，首先像前面人说的，个人能力，游泳 200 米，25 米所需时 18 秒，潜水大于 20 米，这是最基本条件。一般刚到这种程度的，十米内可以下，反之呼喊，打电话等求救。</p>
     <p>然后就是游泳技术比较好的，平时能游泳一千米以上，潜水三四十米这种，二十米内酌情救吧。</p>
     <p>不要小看十来米，在水中拖一百多斤的人，你不要觉得轻松。 换个说法，基本等于你在水中拖个一百多斤的石头。</p>
     <p>不会蛙泳腿的，直接 pass 掉，根本不要下。</p>
     <p>水流湍急，夜晚，不明水域，最好不要下。</p>
     <p>讲个例子，我朋友 185+，体重 200，游泳非常猛，也是救生员。有次夜里碰见一个人跳了一条河，他没敢下去。并不是怂，有时候很无奈，不知道下面有没有水草渔网，夜里你更难判断位置。</p>
     <p>理性，一定要理性，有杆子找杆子。你用杆子拉一个人试试你就知道有多重了，我在游泳馆拉人的时候明显感觉吃力。</p>
     <p>我自己跳下水那次，那人比我重，我基本拖不动，靠岸边人拽一把上来的。</p>
     <p>所以，不鼓励任何游泳不好的人轻易下水，水性特别好的，要特别好的，从小练游泳出身，或者至少学校泳队水平的人，才有资格考虑下水。</p>
     <p>下水需谨慎，求救是第一。</p>
     <p>增加点说明，我们救生员都是经过专业培训的，水中接近，水中解脱，水中拖带。这些都是经过专业培训的，了解这些知识更有利于水中施救。</p>
     <p>简单说一下水中接近：</p>
     <p>水中接近，分三个角度，正面接近，侧面接近，背后接近。</p>
     <p>优先侧面和后面接近，最下策正面接近。</p>
     <p>侧面接近：游到溺水者侧方向，保持一定距离，单手拉住溺水者单侧手腕，迅速将其拉到胸前控制住(你在身后，他背对着你)，另一只手迅速绕过脖子抓住其腋窝，用跨将他顶起，夹胸拖带。 注意夹胸时不要勒住脖子，以防窒息。手扳住腋窝是要点。</p>
     <p>背后接近： 这个比较稳妥，可行性比较高。游到溺水者后方，双手拖住其腋下，将其拖起，然后迅速用一只手夹胸，胯部顶起他，夹胸拖带。</p>
     <p>正面接近：最危险，容易被抱住。 游到溺水者三米处，下潜至溺水者腰部，握住腰部将其反转，顺着腰部往上摸，摸到腋下，将其拖到水面上，然后跟背后接近一样，一只手快速夹胸，胯部顶起他，夹胸拖带。 正面接近危险性大，不到万不得已，优先考虑其他。</p>
     <p>水中解脱，这个不好讲，太多，就是一个反擒拿的意思。你被对方抓住手，头，抱住应该怎么解脱。 被溺水者抱住很严重，你要知道一个人的求生欲望有多强就知道他有多大力气了，死死的抱住你。 这时候就得扳手指，向下沈，各种推脱，万不得已在再踹开。一般不要击打溺水者，以免造成二次伤害。</p>
     <p>水中拖带：最常用单人的就是夹胸拖带。 在背后，一只手绕过脖子然后扳住他的腋下，然后用胯部将他顶起，反蛙泳拖带。 也有拖溺水者脖子的，你用手将他脖子拖住，让他脖子躺在你手上。然后反蛙泳。个人感觉不太好用。</p>
     <p>双人的话就一左一右，一人一个腋下地拖带，不用夹胸用手拉着腋下就行。</p>
     <p>无论几个人施救，你一定要在他身后，一定要将溺水者反过来拖带，不要让他正面抓住你。 无论正面，侧面，背后，第一步是控制住溺水者，将他反过来背对你，切记切记。</p>
     <p>最好的就是用救生设备。</p>
     <p>科学施救，技术立身，关键时刻，保己救人！&nbsp;<br /><br />量力而行！救不了人，不必自责。生命自有定数，万事皆有因果，请认识事物存在的必然性！</p>
     </div>
     </div>


     <div class="view-more"><a href="http://www.zhihu.com/question/46866185">查看知乎讨论<span class="js-question-holder"></span></a></div>

     </div>


     </div>
     </div>
     * image_source : 《情深深雨濛濛》
     * title : 「扑通——」，游泳达到什么水平才能救溺水者
     * image : http://pic1.zhimg.com/c8168af05b32548c3abb0248c0680d20.jpg
     * share_url : http://daily.zhihu.com/story/8388916
     * js : []
     * ga_prefix : 060214
     * images : ["http://pic1.zhimg.com/2a35d2008313bf6b0b5916ea5bcf8140.jpg"]
     * type : 0
     * id : 8388916
     * css : ["http://news-at.zhihu.com/css/news_qa.auto.css?v=4b3e3"]
     */

    private String body;
    private String image_source;
    private String title;
    private String image;
    private String share_url;
    private String ga_prefix;
    private int type;
    private int id;
    private List<?> js;
    private List<String> images;
    private List<String> css;

    public static NewsDetail objectFromData(String str)
    {

        return new Gson().fromJson(str, NewsDetail.class);
    }

    public static NewsDetail objectFromData(String str, String key)
    {

        try
        {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(key), NewsDetail.class);
        } catch (JSONException e)
        {
            e.printStackTrace();
        }

        return null;
    }

    public static List<NewsDetail> arrayNewsDetailFromData(String str)
    {

        Type listType = new TypeToken<ArrayList<NewsDetail>>()
        {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<NewsDetail> arrayNewsDetailFromData(String str, String key)
    {

        try
        {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<NewsDetail>>()
            {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(key), listType);

        } catch (JSONException e)
        {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public String getBody()
    {
        return body;
    }

    public void setBody(String body)
    {
        this.body = body;
    }

    public String getImage_source()
    {
        return image_source;
    }

    public void setImage_source(String image_source)
    {
        this.image_source = image_source;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getImage()
    {
        return image;
    }

    public void setImage(String image)
    {
        this.image = image;
    }

    public String getShare_url()
    {
        return share_url;
    }

    public void setShare_url(String share_url)
    {
        this.share_url = share_url;
    }

    public String getGa_prefix()
    {
        return ga_prefix;
    }

    public void setGa_prefix(String ga_prefix)
    {
        this.ga_prefix = ga_prefix;
    }

    public int getType()
    {
        return type;
    }

    public void setType(int type)
    {
        this.type = type;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public List<?> getJs()
    {
        return js;
    }

    public void setJs(List<?> js)
    {
        this.js = js;
    }

    public List<String> getImages()
    {
        return images;
    }

    public void setImages(List<String> images)
    {
        this.images = images;
    }

    public List<String> getCss()
    {
        return css;
    }

    public void setCss(List<String> css)
    {
        this.css = css;
    }
}
