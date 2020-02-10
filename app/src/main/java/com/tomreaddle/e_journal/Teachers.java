package com.tomreaddle.e_journal;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tomreaddle.e_journal.API.Client.RetrofitClientInfo;
import com.tomreaddle.e_journal.API.Model.TeacherData;
import com.tomreaddle.e_journal.API.ResService.ApiService;
import com.tomreaddle.e_journal.Adapters.Teachers_Adapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Teachers extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.teachers);

        recyclerView = findViewById(R.id.teacher_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.hasFixedSize();

        ApiService api = RetrofitClientInfo.getApiService();
                Call<List<TeacherData>> call = api.getTeacherData();
                call.enqueue(new Callback<List<TeacherData>>() {
                    @Override
                    public void onResponse(Call<List<TeacherData>> call, Response<List<TeacherData>> response) {
                        if(response.isSuccessful()) {

                            List<TeacherData> list = response.body();
                            recyclerView.setAdapter(new Teachers_Adapter(getApplicationContext() , list));
                        } else {
                        }

                    }

                    @Override
                    public void onFailure(Call<List<TeacherData>> call, Throwable t) {
                    }
                });

    }
}
