package com.tomreaddle.e_journal.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.tomreaddle.e_journal.Models.model_today_rank;
import com.tomreaddle.e_journal.R;

import java.util.List;

public class Rank_Adapter extends RecyclerView.Adapter<Rank_Adapter.MyViewHolder> {

    private Context context;
    private List<model_today_rank> data;

    public Rank_Adapter(Context context, List<model_today_rank> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.item_subject_today , parent , false);
        return new MyViewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.subject.setText(data.get(position).getsubject_name());
        holder.teacher.setText(data.get(position).getTeacher_fname() + " " + data.get(position).getTeacher_lname());
        holder.theme.setText(data.get(position).getTheme());
        holder.homework.setText(data.get(position).getHomework());
        holder.rank.setText(data.get(position).getRank());

        int rank_int = Integer.parseInt(holder.rank.getText().toString());
        Integer color_text = R.color.rank_no , color_icon = R.color.rank_no_ic , background = R.drawable.rank_no;
        if(rank_int== 0) { color_text = holder.itemView.getResources().getColor(R.color.rank_no); color_icon = holder.itemView.getResources().getColor(R.color.rank_no_ic); background = R.drawable.rank_no; }
        if(rank_int== 3) { color_text = holder.itemView.getResources().getColor(R.color.rank_3); color_icon = holder.itemView.getResources().getColor(R.color.rank_3_ic); background = R.drawable.rank_3; }
        if(rank_int== 4) { color_text = holder.itemView.getResources().getColor(R.color.rank_4); color_icon = holder.itemView.getResources().getColor(R.color.rank_4_ic); background = R.drawable.rank_4; }
        if(rank_int== 5) { color_text = holder.itemView.getResources().getColor(R.color.rank_5); color_icon = holder.itemView.getResources().getColor(R.color.rank_5_ic); background = R.drawable.rank_5; }

        if(rank_int == 0) holder.rank_rank.setVisibility(View.INVISIBLE);
        holder.item_rank_today.setBackgroundResource(background);
        holder.subject.setTextColor(color_text);
        holder.teacher.setTextColor(color_text);
        holder.theme.setTextColor(color_text);
        holder.homework.setTextColor(color_text);
        holder.rank.setTextColor(color_text);
        holder.teacher_ic.setColorFilter(color_icon);
        holder.theme_ic.setColorFilter(color_icon);
        holder.homework_ic.setColorFilter(color_icon);
        holder.rank_ic.setColorFilter(color_icon);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        RelativeLayout item_rank_today;
        TextView subject;
        TextView teacher;
        TextView theme;
        TextView homework;
        TextView rank;
        ImageView teacher_ic;
        ImageView theme_ic;
        ImageView homework_ic;
        ImageView rank_ic;
        LinearLayout rank_rank;
        int rank_int;


        public MyViewHolder(View itemView){
            super(itemView);

            item_rank_today = (RelativeLayout) itemView.findViewById(R.id.item_rank_today);
            subject = (TextView) itemView.findViewById(R.id.rank_subject_name);
            teacher = (TextView) itemView.findViewById(R.id.rank_teacher_name);
            teacher_ic = (ImageView) itemView.findViewById(R.id.rank_teacher_ic);
            theme = (TextView) itemView.findViewById(R.id.rank_theme_name);
            theme_ic = (ImageView) itemView.findViewById(R.id.rank_theme_ic);
            homework = (TextView) itemView.findViewById(R.id.rank_hw_name);
            homework_ic = (ImageView) itemView.findViewById(R.id.rank_hw_ic);
            rank = (TextView) itemView.findViewById(R.id.rank_rank_name);
            rank_ic = (ImageView) itemView.findViewById(R.id.rank_rank_ic);
            rank_rank = (LinearLayout) itemView.findViewById(R.id.rank_rank);

        }

    }
}
