package com.tomreaddle.e_journal;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.tomreaddle.e_journal.API.Client.RetrofitClient;
import com.tomreaddle.e_journal.API.Model.LoginData;
import com.tomreaddle.e_journal.API.Model.TokenData;
import com.tomreaddle.e_journal.API.ResService.ApiService;
import com.tomreaddle.e_journal.Services.MySharedPreferences;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class add_profile extends AppCompatActivity {

    ImageView back;
    TextView add_id , add_password;
    Button add_add_button;
    MySharedPreferences mySharedPreferences;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_profile);

        back = findViewById(R.id.back_add);
        add_id = findViewById(R.id.add_id);
        add_password = findViewById(R.id.add_password);
        add_add_button= findViewById(R.id.add_add_button);

        mySharedPreferences = new MySharedPreferences(this);

        add_add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });


    }

    public void login(){

        String email , password;
        email = add_id.getText().toString();
        password = add_password.getText().toString();
        LoginData loginData = new LoginData(email , password);

        ApiService api = RetrofitClient.getApiService();
        Call<TokenData> call = api.login(loginData);
        call.enqueue(new Callback<TokenData>() {
            @Override
            public void onResponse(Call<TokenData> call, Response<TokenData> response) {
                if(response.isSuccessful()){
                    mySharedPreferences.setLang(response.body().getToken());
                    Toast.makeText(add_profile.this, R.string.login_done, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(add_profile.this, R.string.login_error, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<TokenData> call, Throwable t) {
                Toast.makeText(add_profile.this, "NO :-(", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
