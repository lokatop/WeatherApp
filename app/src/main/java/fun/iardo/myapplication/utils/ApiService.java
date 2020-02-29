package fun.iardo.myapplication.utils;

import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import fun.iardo.myapplication.BuildConfig;
import fun.iardo.myapplication.data.api.IWeatherApi;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {
    private static OkHttpClient sClient;
    private static Retrofit sRetrofit;
    private static Gson sGson;
    private static IWeatherApi sApi;

    private static OkHttpClient getClient(){
        if (sClient == null) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient.Builder builder = new OkHttpClient.Builder()
                    //.connectTimeout(10000, TimeUnit.SECONDS)
                    //.readTimeout(10000,TimeUnit.SECONDS)
                    //.addInterceptor(new ApiKeyInterceptor());
                    .addInterceptor(logging);

            sClient = builder.build();
        }
        return sClient;
    }

    private static Retrofit getRetrofit(String baseUrl){
        if (sGson == null){sGson = new Gson();}
        if (sRetrofit == null){
            sRetrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(getClient())
                    .addConverterFactory(GsonConverterFactory.create(sGson))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return sRetrofit;
    }


    public static IWeatherApi getApiService(String baseUrl){
        if (sApi == null){
            sApi = getRetrofit(baseUrl).create(IWeatherApi.class);
        }
        return sApi;
    }
}
