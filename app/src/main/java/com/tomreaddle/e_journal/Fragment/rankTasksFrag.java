package com.tomreaddle.e_journal.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.tomreaddle.e_journal.R;

public class rankTasksFrag extends Fragment {

    View view;
    FrameLayout fragment;
    Button today , tomorrow;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.rank_tasks , null);

        fragment = view.findViewById(R.id.rank_fragment_container);

        today = view.findViewById(R.id.today_tasks);
        tomorrow = view.findViewById(R.id.tomorrow_tasks);

        setRankFrag();

        today.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setRankFrag();

            }
        });

        tomorrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTasksFrag();
            }
        });

        return view;
    }

    public void setRankFrag(){
        tomorrow.setBackgroundResource(R.color.transparent);
        today.setBackgroundResource(R.drawable.rank_tasks_nav_but_back_up);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        rankTasksFragToday rankTasksFragToday = new rankTasksFragToday();
        fragmentTransaction.replace(R.id.rank_fragment_container , rankTasksFragToday);
        fragmentTransaction.commit();
    }

    public void setTasksFrag(){

        today.setBackgroundResource(R.color.transparent);
        tomorrow.setBackgroundResource(R.drawable.rank_tasks_nav_but_back_down);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        rankTasksFragTomorrow rankTasksFragTomorrow = new rankTasksFragTomorrow();
        fragmentTransaction.replace(R.id.rank_fragment_container , rankTasksFragTomorrow);
        fragmentTransaction.commit();
    }


}
