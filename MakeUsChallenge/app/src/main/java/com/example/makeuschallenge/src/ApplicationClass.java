package com.example.makeuschallenge.src;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.makeuschallenge.config.XAccessTokenInterceptor;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApplicationClass extends Application {
    public static MediaType MEDIA_TYPE_JSON = MediaType.parse("application/json; charset=uft-8");
    public static MediaType MEDIA_TYPE_JPEG = MediaType.parse("image/jpeg");

    //테스트 서버주소
    public static String BASE_URL = "http://13.125.20.10:3000";

    //SharedPreferences 키 값
    public static String TAG = "TEMPLATE_APP";

    //날짜 형식
    public static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);

    //Retrofit 인스턴스
    public static Retrofit retrofit;

    public static SharedPreferences sSharedPreferences = null;

    //JWT Token값
    public static String X_ACCESS_TOKEN = "X-ACCESS-TOKEN";


    @Override
    public void onCreate() {
        super.onCreate();
        if(sSharedPreferences==null) {
            sSharedPreferences = getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        }
    }

    public static Retrofit getRetrofit(){
        if(retrofit==null){
            OkHttpClient client = new OkHttpClient.Builder()
                    .readTimeout(5000, TimeUnit.MILLISECONDS)
                    .connectTimeout(5000,TimeUnit.MILLISECONDS)
                    .addNetworkInterceptor(new XAccessTokenInterceptor())
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
