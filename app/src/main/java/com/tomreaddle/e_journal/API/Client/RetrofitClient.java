package com.tomreaddle.e_journal.API.Client;

import com.tomreaddle.e_journal.API.ResService.ApiService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static final String URL_BASE = "https://schools.uz/api/";

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
