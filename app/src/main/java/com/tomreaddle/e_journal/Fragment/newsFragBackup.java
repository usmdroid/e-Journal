package com.tomreaddle.e_journal.Fragment;

import android.animation.ArgbEvaluator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.tomreaddle.e_journal.Adapters.News_Pager_Adapter;
import com.tomreaddle.e_journal.Models.model_news_item;
import com.tomreaddle.e_journal.R;

import java.util.ArrayList;
import java.util.List;

public class newsFragBackup extends Fragment {

    View view;
    ViewPager2 viewPager;
    News_Pager_Adapter adapter;
    Integer color[] =  null;
    ArgbEvaluator evaluator = new ArgbEvaluator();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.news_fragment_backup, null);

        viewPager = view.findViewById(R.id.viewpager);
        List<model_news_item>  model = new ArrayList<>();
//        model.add(new model_news_item(R.string.news_back , "Bugun maktabda" , "ko'p narsa bo'ldi" , "20.01.2019" , "15:35"));
//        model.add(new model_news_item(R.string.news_back , "Bugun maktabda" , "ko'p narsa bo'ldi" , "20.01.2019" , "15:35"));
//        model.add(new model_news_item(R.string.news_back , "Bugun maktabda" , "ko'p narsa bo'ldi" , "20.01.2019" , "15:35"));
        Toast.makeText(view.getContext(), "ishladi", Toast.LENGTH_SHORT).show();
        viewPager.setAdapter(new News_Pager_Adapter(model , view.getContext()));

        return view;
    }

}
