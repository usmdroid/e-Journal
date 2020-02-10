package com.tomreaddle.e_journal;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tomreaddle.e_journal.API.Client.RetrofitClientInfo;
import com.tomreaddle.e_journal.API.Model.AttendanceData;
import com.tomreaddle.e_journal.API.ResService.ApiService;
import com.tomreaddle.e_journal.Adapters.Attendance_Adapter;
import com.tomreaddle.e_journal.Adapters.Teachers_Adapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Attendance extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.attendance);

        recyclerView = findViewById(R.id.attendance_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.hasFixedSize();

        ApiService api = RetrofitClientInfo.getApiService();
                Call<List<AttendanceData>> call = api.getAttendanceData();
                call.enqueue(new Callback<List<AttendanceData>>() {
                    @Override
                    public void onResponse(Call<List<AttendanceData>> call, Response<List<AttendanceData>> response) {
                        if(response.isSuccessful()) {
                            List<AttendanceData> list = response.body();
                            recyclerView.setAdapter(new Attendance_Adapter(getApplicationContext() , list));
                        } else {
                            Toast.makeText(Attendance.this, R.string.upload_error, Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<List<AttendanceData>> call, Throwable t) {
                        Toast.makeText(Attendance.this, R.string.connecting_error, Toast.LENGTH_SHORT).show();

                    }
                });

    }
}
