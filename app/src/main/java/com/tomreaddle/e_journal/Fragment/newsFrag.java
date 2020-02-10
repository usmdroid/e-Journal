package com.tomreaddle.e_journal.Fragment;

import android.animation.ArgbEvaluator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.tomreaddle.e_journal.Adapters.News_Pager_Adapter;
import com.tomreaddle.e_journal.Models.model_news_item;
import com.tomreaddle.e_journal.R;

import java.util.ArrayList;
import java.util.List;

public class newsFrag extends Fragment {

    View view;
    ViewPager viewPager;
    News_Pager_Adapter adapter;
    List<model_news_item> model;
    Integer color[] =  null;
    ArgbEvaluator evaluator = new ArgbEvaluator();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.news_fragment , null);

        model = new ArrayList<>();
        model.add(new model_news_item(R.color.color1 , "Bugun maktabda" , "ko'p narsa bo'ldi" , "20.01.2019" , "15:35"));
        model.add(new model_news_item(R.color.color1 , "Bugun maktabda" , "ko'p narsa bo'ldi" , "20.01.2019" , "15:35"));
        model.add(new model_news_item(R.color.color1 , "Bugun maktabda" , "ko'p narsa bo'ldi" , "20.01.2019" , "15:35"));

    //        adapter = new News_Pager_Adapter(model , view.getContext());
    //        viewPager = view.findViewById(R.id.viewpager);

        return view;
    }

}
