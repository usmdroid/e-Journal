package com.tomreaddle.e_journal.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tomreaddle.e_journal.API.Client.RetrofitClientInfo;
import com.tomreaddle.e_journal.API.ResService.ApiService;
import com.tomreaddle.e_journal.Adapters.Rank_Adapter;
import com.tomreaddle.e_journal.Models.model_today_rank;
import com.tomreaddle.e_journal.R;
import com.tomreaddle.e_journal.Services.MySharedPreferencesSettings;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class rankTasksFragToday extends Fragment {

    View view;
    FrameLayout fragment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.rank_frag_today , null);

        RecyclerView recyclerView = view.findViewById(R.id.RecRanks);
        recyclerView.setLayoutManager(new GridLayoutManager(view.getContext() , 3));

        ApiService api = RetrofitClientInfo.getApiService();
        Call<List<model_today_rank>> call = api.getTimeTable();
        call.enqueue(new Callback<List<model_today_rank>>() {
            @Override
            public void onResponse(Call<List<model_today_rank>> call, Response<List<model_today_rank>> response) {
                if (response.isSuccessful()){
                    List<model_today_rank> list = response.body();
                    Rank_Adapter adapter = new Rank_Adapter(view.getContext() , list);
                    recyclerView.setAdapter(adapter);
                } else {
                    Toast.makeText(getContext(), "Server bilan muammo", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<model_today_rank>> call, Throwable t) {
                Toast.makeText(getContext(), "Ulanishda xatolik", Toast.LENGTH_SHORT).show();
            }
        });

        MySharedPreferencesSettings mySharedPreferences = new MySharedPreferencesSettings(view.getContext());
        String token = mySharedPreferences.getToken();

        return view;
    }

}
