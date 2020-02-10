package com.tomreaddle.e_journal.API.Client;

import com.tomreaddle.e_journal.API.ResService.ApiService;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.provider.UserDictionary.Words.APP_ID;

public class RetrofitClientInfo {

    private static final String URL_BASE = "https://usmano8102.000webhostapp.com/";

    private static Retrofit getRetrofitInstance(){

        return new Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ApiService getApiService() {
        return getRetrofitInstance().create(ApiService.class);
    }
}
