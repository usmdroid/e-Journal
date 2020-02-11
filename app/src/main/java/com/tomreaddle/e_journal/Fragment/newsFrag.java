package com.tomreaddle.e_journal.Fragment;

import android.animation.ArgbEvaluator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.tomreaddle.e_journal.API.Client.RetrofitClientInfo;
import com.tomreaddle.e_journal.API.Model.AttendanceData;
import com.tomreaddle.e_journal.API.ResService.ApiService;
import com.tomreaddle.e_journal.Adapters.Attendance_Adapter;
import com.tomreaddle.e_journal.Adapters.News_Pager_Adapter;
import com.tomreaddle.e_journal.Models.model_news_item;
import com.tomreaddle.e_journal.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class newsFrag extends Fragment {

    View view;
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.news_fragment , null);

        recyclerView = view.findViewById(R.id.notes_school_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.hasFixedSize();

        ApiService api = RetrofitClientInfo.getApiService();
        Call<List<model_news_item>> call = api.getNotificationData();
        call.enqueue(new Callback<List<model_news_item>>() {
            @Override
            public void onResponse(Call<List<model_news_item>> call, Response<List<model_news_item>> response) {
                if(response.isSuccessful()){
                    List<model_news_item> list = response.body();
                    recyclerView.setAdapter(new News_Pager_Adapter(list, view.getContext()));
                }else {
                    Toast.makeText(view.getContext(), R.string.upload_error, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<model_news_item>> call, Throwable t) {
                Toast.makeText(view.getContext(), R.string.connecting_error, Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

}
