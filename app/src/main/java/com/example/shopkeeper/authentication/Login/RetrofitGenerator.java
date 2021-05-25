package com.example.shopkeeper.authentication.Login;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.strategy.Strategy;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 * Retrofit变量初始化
 * Created by Jeeson on 16/7/16.
 */
public class RetrofitGenerator {

//    http://ms.projectspreview.net:2001/myservice.asmx
    public final static String BASE_URL = "http://ms.projectspreview.net:2001/";

    public static ApiService apiService;

    private static Strategy strategy = new AnnotationStrategy();
    private static Serializer serializer = new Persister(strategy);


    private static OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();

    private static Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
            .addConverterFactory(SimpleXmlConverterFactory.create(serializer))
            .addConverterFactory(GsonConverterFactory.create());

    public static <S> S createService(Class<S> serviceClass, String baseUrl) {
        okHttpClient.interceptors().add(chain -> {
            Request original = chain.request();

            Request.Builder requestBuilder = original.newBuilder()
                    .header("Content-Type", "text/xml; charset=utf-8")   // 对于SOAP 1.1， 如果是soap1.2 应是Content-Type: application/soap+xml; charset=utf-8// 对于SOAP 1.1， 如果是soap1.2 应是Content-Type: application/soap+xml; charset=utf-8
                    .method(original.method(), original.body());

            Request request = requestBuilder.build();
            return chain.proceed(request);
        });
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = okHttpClient.connectTimeout(2, TimeUnit.MINUTES)
                .writeTimeout(2, TimeUnit.MINUTES)
                .readTimeout(2, TimeUnit.MINUTES)
                .addInterceptor(interceptor)
                .build();
        Retrofit retrofit = retrofitBuilder.baseUrl(baseUrl).client(client).build();
        return retrofit.create(serviceClass);
    }

    public static ApiService getApiService() {
        if (apiService == null) {
            apiService = createService(ApiService.class, BASE_URL);
        }
        return apiService;

    }

}
