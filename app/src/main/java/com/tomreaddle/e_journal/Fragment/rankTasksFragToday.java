package com.tomreaddle.e_journal.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tomreaddle.e_journal.Adapters.Rank_Adapter;
import com.tomreaddle.e_journal.Models.model_today_rank;
import com.tomreaddle.e_journal.R;

import java.util.ArrayList;
import java.util.List;

public class rankTasksFragToday extends Fragment {

    View view;
    FrameLayout fragment;
    List<model_today_rank> list;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.rank_frag_today , null);

        list = new ArrayList<>();

        list.add(new model_today_rank("Adabiyot" , "Shoqosimova Aziza" , "Mirzo Muhammad Bobur hayoti va ijodi" , "Muhammad Bobur hayoti va ijodini o'qish va g'azallaridan yodlash" , "3"));
        list.add(new model_today_rank("Kimyo" , "Aziza Xo'jayeva" , "Oksidlar" , "Tajriba" , "4"));
        list.add(new model_today_rank("Biologiya" , "Aziza Xo'jayeva" , "Sut emizuvchilar" , "Oraliq nazorat" , "0"));
        list.add(new model_today_rank("Matematika" , "Aziza Xo'jayeva" , "Arifmetika" , "Guruhlash" , "5"));
        list.add(new model_today_rank("Matematika" , "Aziza Xo'jayeva" , "Arifmetika" , "Guruhlash" , "5"));
        list.add(new model_today_rank("Biologiya" , "Aziza Xo'jayeva" , "Sut emizuvchilar" , "Oraliq nazorat" , "0"));

        RecyclerView recyclerView = view.findViewById(R.id.RecRanks);
        Rank_Adapter adapter = new Rank_Adapter(view.getContext() , list);
        recyclerView.setLayoutManager(new GridLayoutManager(view.getContext() , 3));
        recyclerView.setAdapter(adapter);

        return view;
    }

}
