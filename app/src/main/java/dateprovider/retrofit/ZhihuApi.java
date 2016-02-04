package dateprovider.retrofit;


import dateprovider.model.LatestNews;
import dateprovider.model.NewsBefore;
import dateprovider.model.NewsDetail;
import dateprovider.model.NewsExtra;
import dateprovider.model.NewsLongComment;
import dateprovider.model.NewsShortComment;
import dateprovider.model.NewsTheme;
import dateprovider.model.NewsThemeDetail;
import dateprovider.model.StartPicture;
import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

/**
 * Created by qiuxuechuan on 2015/11/30.
 *
 * @Header("access_token") String accesstoken  header参数
 * @Query("deviceSerialNo") query参数
 * @FormUrlEncoded 表单参数
 */
public interface ZhihuApi {

    /*    @FormUrlEncoded
        @POST("/getC_N")
        Observable<OneArticle> getOneArticle(@Field("strDate") String strDate, @Field("strRow") int strRow, @Field("strMS") int strMS);*/
    //分辨率 1080*1776
    @GET("/start-image/{ratio}")
    Observable<StartPicture> getStartPicture(@Path("ratio") String ratio);


    @GET("/news/latest")
    Observable<LatestNews> getLatestNews();

    //http://news-at.zhihu.com/api/4/news/3892357
    @GET("/news/{newsid}")
    Observable<NewsDetail> getNewsDetail(@Path("newsid") String newsid);


    //http://news.at.zhihu.com/api/4/news/before/20131119
    @GET("/news/before/{date}")
    Observable<NewsBefore> getNewsDetailBefore(@Path("date") String date);

    //新闻额外消息 点赞什么的
    //http://news-at.zhihu.com/api/4/story-extra/1747159
    @GET("/news/story-extra/{newsid}")
    Observable<NewsExtra> getNewsExtra(@Path("newsid") String newsid);

    //新闻长评论
    //http://news-at.zhihu.com/api/4/story/4232852/long-comments
    @GET("/story/{newsid}/long-comments")
    Observable<NewsLongComment> getNewsLongComment(@Path("newsid") String newsid);


    //新闻短评论
    //http://news-at.zhihu.com/api/4/story/4232852/short-comments
    @GET("/story/{newsid}/short-comments")
    Observable<NewsShortComment> getNewsShortComment(@Path("newsid") String newsid);


    //新闻主题
    //http://news-at.zhihu.com/api/4/themes
    @GET("/themes")
    Observable<NewsTheme> getThemes();


    //主题日报
    //http://news-at.zhihu.com/api/4/theme/11
    @GET("/themes/{themesid}")
    Observable<NewsThemeDetail> getThemesNews(@Path("themesid") String themesid);


}
