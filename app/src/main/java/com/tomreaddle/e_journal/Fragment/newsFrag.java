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
        model.add(new model_news_item(R.color.color1 , "Bugun maktabda" , "ko'p narsa bo'ldi" , "15:35 20.01.2019"));
        model.add(new model_news_item(R.color.color2 , "Bugun maktabda" , "ko'p narsa bo'ldi" , "15:35 20.01.2019"));
        model.add(new model_news_item(R.color.color3 , "Bugun maktabda" , "ko'p narsa bo'ldi" , "15:35 20.01.2019"));
        model.add(new model_news_item(R.color.color4 , "Bugun maktabda" , "ko'p narsa bo'ldi" , "15:35 20.01.2019"));
        model.add(new model_news_item(R.color.color5 , "Bugun maktabda" , "ko'p narsa bo'ldi" , "15:35 20.01.2019"));

        adapter = new News_Pager_Adapter(model , view.getContext());
        viewPager = view.findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(150,0,150,0);
        Integer[] color_temp = {
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color3),
                getResources().getColor(R.color.color4),
                getResources().getColor(R.color.color5)
        };

        color = color_temp;

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if(position < (adapter.getCount() - 1) && position < color.length -1){
                    viewPager.setBackgroundColor(
                            (Integer) evaluator.evaluate(
                                    positionOffset ,
                                    color[position] ,
                                    color[position + 1]
                            )
                    );
                } else {
                    viewPager.setBackgroundColor(color[color.length - 1]);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        return view;
    }

}
