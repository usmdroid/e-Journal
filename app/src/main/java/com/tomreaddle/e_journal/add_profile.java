package com.tomreaddle.e_journal;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.tomreaddle.e_journal.API.Client.RetrofitClient;
import com.tomreaddle.e_journal.API.Client.RetrofitClientInfo;
import com.tomreaddle.e_journal.API.Model.InfoData;
import com.tomreaddle.e_journal.API.Model.LoginData;
import com.tomreaddle.e_journal.API.Model.TokenData;
import com.tomreaddle.e_journal.API.ResService.ApiService;
import com.tomreaddle.e_journal.DB.DBHelper;
import com.tomreaddle.e_journal.Services.MySharedPreferencesSettings;
import com.tomreaddle.e_journal.Services.MySharedPreferencesData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class add_profile extends AppCompatActivity {

    TextView add_id , add_password;
    Button add_add_button;
    DBHelper dbHelper;
    private static String token;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.add_profile);

        add_id = findViewById(R.id.add_id);
        add_password = findViewById(R.id.add_password);
        add_add_button= findViewById(R.id.add_add_button);

        getInfo();

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

        MySharedPreferencesSettings mySharedPreferences1 = new MySharedPreferencesSettings(this);
        ApiService api = RetrofitClient.getApiService();
        Call<TokenData> call = api.login(loginData);
        call.enqueue(new Callback<TokenData>() {
            @Override
            public void onResponse(Call<TokenData> call, Response<TokenData> response) {
                if(response.isSuccessful()){
                    Toast.makeText(add_profile.this, R.string.login_done, Toast.LENGTH_SHORT).show();
                    token = response.body().getToken();
                    mySharedPreferences1.setToken(token);
                    finish();
                    startActivity(new Intent(add_profile.this , MainActivity.class));
                } else {
                    Toast.makeText(add_profile.this, R.string.login_error, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<TokenData> call, Throwable t) {
                Toast.makeText(add_profile.this, "Ma'lumot almashishda xatolik", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onBackPressed() {
        MySharedPreferencesSettings mySharedPreferences = new MySharedPreferencesSettings(this);
        if(!mySharedPreferences.getToken().equals("")) {
            super.onBackPressed();
        } else {
            finish();
            System.exit(0);
        }
    }

    public void getInfo(){
        Toast.makeText(add_profile.this, "getInfo", Toast.LENGTH_SHORT).show();
        ApiService api = RetrofitClientInfo.getApiService();
        Call<InfoData> call = api.getInfo();
        call.enqueue(new Callback<InfoData>() {
            @Override
            public void onResponse(Call<InfoData> call, Response<InfoData> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(add_profile.this, "Ishladi", Toast.LENGTH_SHORT).show();
                    InfoData item = response.body();
                    String name , school , class_num , teacher_name , adress , adress_full , adress_mail , phone , director;
                    name = item.getFirst_name()+" "+item.getLast_name();
                    school = item.getSchool_name();
                    class_num = item.getClass_name();
                    teacher_name = item.getTeacher_fname()+" "+item.getTeacher_lname();
                    adress = item.getAdress();
                    adress_full = item.getAdress_full();
                    adress_mail = item.getAdress_mail();
                    phone = item.getPhone();
                    director = item.getDirector();

                    MySharedPreferencesData mySharedPreferences = new MySharedPreferencesData(getApplicationContext());
                    mySharedPreferences.setNameProfile(name);
                    mySharedPreferences.setSchoolProfile(school);
                    mySharedPreferences.setClassProfile(class_num);
                    mySharedPreferences.setTeacherNameProfile(teacher_name);
                    mySharedPreferences.setAdressProfile(adress);
                    mySharedPreferences.setAdressFullProfile(adress_full);
                    mySharedPreferences.setAdressMailProfile(adress_mail);
                    mySharedPreferences.setPhoneProfile(phone);
                    mySharedPreferences.setDirectorProfile(director);

                } else {
                }
                Toast.makeText(add_profile.this, R.string.login_done, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<InfoData> call, Throwable t) {
            }
        });
    }
}
