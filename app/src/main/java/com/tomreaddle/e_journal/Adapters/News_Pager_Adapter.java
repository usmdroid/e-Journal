package com.tomreaddle.e_journal.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.PagerAdapter;

import com.tomreaddle.e_journal.Models.model_news_item;
import com.tomreaddle.e_journal.R;

import java.util.List;

public class News_Pager_Adapter extends PagerAdapter {

    private List<model_news_item> model;
    private LayoutInflater inflater;
    private Context context;

    public News_Pager_Adapter(List<model_news_item> model, Context context) {
        this.model = model;
        this.context = context;
    }

    @Override
    public int getCount() {
        return model.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(context );
        View view = inflater.inflate(R.layout.item_news, container , false);
        ImageView image;
        TextView theme , excerpt , date;

        image = view.findViewById(R.id.news_item_image);
        theme = view.findViewById(R.id.news_item_theme);
        excerpt = view.findViewById(R.id.news_item_excerpt);
        date = view.findViewById(R.id.news_item_date);

        container.addView(view , 0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
