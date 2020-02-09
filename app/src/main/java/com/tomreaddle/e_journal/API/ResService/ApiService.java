package com.tomreaddle.e_journal.API.ResService;

import com.tomreaddle.e_journal.API.Model.InfoData;
import com.tomreaddle.e_journal.API.Model.LoginData;
import com.tomreaddle.e_journal.API.Model.TokenData;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiService {

    @POST("login")
    Call<TokenData> login(@Body LoginData loginData);

    @GET("student/info")
    Call<InfoData> getInfo(@Header("Authorization") String Authtoken);
}
