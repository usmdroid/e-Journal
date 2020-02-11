package com.tomreaddle.e_journal.Fragment;

import java.util.List;
import android.os.Bundle;
import android.view.View;
import java.util.ArrayList;
import android.view.ViewGroup;

import com.tomreaddle.e_journal.API.Client.RetrofitClientInfo;
import com.tomreaddle.e_journal.API.ResService.ApiService;
import com.tomreaddle.e_journal.Models.model_news_item;
import com.tomreaddle.e_journal.R;
import android.view.LayoutInflater;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.tomreaddle.e_journal.Adapters.Task_Adapter;
import androidx.recyclerview.widget.GridLayoutManager;
import com.tomreaddle.e_journal.Models.model_tomorrow_task;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class rankTasksFragTomorrow extends Fragment {

    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.rank_frag_tomorrow , null);

        RecyclerView recyclerView = view.findViewById(R.id.RecTasks);
        recyclerView.setLayoutManager(new GridLayoutManager(view.getContext() , 3));

        ApiService api = RetrofitClientInfo.getApiService();
        Call<List<model_tomorrow_task>> call = api.getTomorrowTasks();
        call.enqueue(new Callback<List<model_tomorrow_task>>() {
            @Override
            public void onResponse(Call<List<model_tomorrow_task>> call, Response<List<model_tomorrow_task>> response) {
                if (response.isSuccessful()){
                List<model_tomorrow_task> list = response.body();
                recyclerView.setAdapter(new Task_Adapter(view.getContext() , list));
                } else {
                    Toast.makeText(view.getContext(), R.string.upload_error, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<model_tomorrow_task>> call, Throwable t) {
                Toast.makeText(view.getContext(), R.string.connecting_error, Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

}
