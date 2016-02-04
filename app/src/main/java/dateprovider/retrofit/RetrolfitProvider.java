package dateprovider.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.squareup.okhttp.OkHttpClient;
import com.zhihu.chuankris.myapplication.preferrence.AppConfig;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;

/**
 * Created by xuweidong on 2015/12/9.
 */
public class RetrolfitProvider {
    private static final ThreadLocal<RetrolfitProvider> instance = new ThreadLocal<>();
    private OneApi OneApi;
    private ZhihuApi zhihuApi;

    private static final String ONE_URL = AppConfig.getOneUrl();
    private static final String ZHIHU_URL = AppConfig.getZhihuUrl();
    final static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss")
//            .registerTypeAdapter(java.util.Date.class, new DateSerializer())//json编码
//            .registerTypeAdapter(java.util.Date.class, new DateDeserializer())//json解码
            //.setDateFormat(DateFormat.LONG)//日期格式
            .serializeNulls()//解析null
            .create();

    private RetrolfitProvider() {
        init();
    }

    public OneApi getOneApi() {
        return OneApi;
    }

    public ZhihuApi getZhihuApi() {
        return zhihuApi;
    }

    /**
     * 单例
     *
     * @return
     */
    public static RetrolfitProvider getInstance() {
        if (instance.get() == null) {
            synchronized (RetrolfitProvider.class) {
                if (instance.get() == null) {
                    instance.set(new RetrolfitProvider());
                }
            }
        }
        return instance.get();
    }

    private void init() {
        OkHttpClient client = new OkHttpClient();
        client.setReadTimeout(12, TimeUnit.SECONDS);
        RestAdapter.Builder builder = new RestAdapter.Builder();
        RestAdapter oneAdapter = builder.
                setClient(new OkClient(client)).
                setEndpoint(ONE_URL).
                setConverter(new GsonConverter(gson)).
                build();
        oneAdapter.setLogLevel(RestAdapter.LogLevel.FULL);
        OneApi = oneAdapter.create(OneApi.class);


        RestAdapter zhihuAdapter = builder.setClient(new OkClient(client)).setEndpoint(ZHIHU_URL).setConverter(new GsonConverter(gson)).build();
        zhihuAdapter.setLogLevel(RestAdapter.LogLevel.FULL);
        zhihuApi = zhihuAdapter.create(ZhihuApi.class);
    }


    public interface Callback {

    }

    /**
     * Date转json是转为long
     */
    public static class DateDeserializer implements JsonDeserializer<Date> {
        public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            return new java.util.Date(json.getAsJsonPrimitive().getAsLong());
        }
    }

    /**
     * long转json时转为Date
     */
    public static class DateSerializer implements JsonSerializer<Date> {
        public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
            return new JsonPrimitive(src.getTime());
        }
    }

}
