package com.tomreaddle.e_journal.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.tomreaddle.e_journal.Models.model_news_item;
import com.tomreaddle.e_journal.R;

import java.util.List;

public class News_Pager_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<model_news_item> data;
    private ViewPager viewPager2;

    public News_Pager_Adapter(List<model_news_item> model, ViewPager viewPager2) {
        this.data = model;
        this.viewPager2 = viewPager2;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news , parent , false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        public ImageView image;
        public TextView theme , excerpt , date;

        public MyViewHolder(View itemView){
            super(itemView);

            image = itemView.findViewById(R.id.news_item_image);
            theme = itemView.findViewById(R.id.news_item_theme);
            excerpt = itemView.findViewById(R.id.news_item_excerpt);
            date = itemView.findViewById(R.id.news_item_date);

        }
    }
}

