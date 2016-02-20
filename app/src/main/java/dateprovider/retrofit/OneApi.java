package dateprovider.retrofit;


import dateprovider.model.OneArticle;
import dateprovider.model.OneArticleList;
import dateprovider.model.OneNewArticle;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import rx.Observable;

/**
 * Created by qiuxuechuan on 2015/11/30.
 *
 * @Header("access_token") String accesstoken  header参数
 * @Query("deviceSerialNo") query参数
 * @FormUrlEncoded 表单参数
 */
public interface OneApi {

    @FormUrlEncoded
    @POST("/getC_N")
    Observable<OneArticle> getOneArticle(@Field("strDate") String strDate, @Field("strRow") int strRow, @Field("strMS") int strMS);


    /*    每个月的列表
    v3.wufazhuce.com:8000

     /api/essay/bymonth/2015-11-01%2000:00:00?*/

    @GET("/api/essay/bymonth/{date}")
    Observable<OneArticleList> getOneArticleList(@Path("date") String date);


    @GET("//api/essay/{articleid}")
    Observable<OneNewArticle> getOneArticleNew(@Path("articleid") String articleid);


}
