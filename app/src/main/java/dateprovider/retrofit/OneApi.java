package dateprovider.retrofit;


import dateprovider.model.OneArticle;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;
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


}
