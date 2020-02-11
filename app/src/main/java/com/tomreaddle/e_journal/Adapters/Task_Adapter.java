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

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tomreaddle.e_journal.Models.model_today_rank;
import com.tomreaddle.e_journal.Models.model_tomorrow_task;
import com.tomreaddle.e_journal.R;

import java.util.List;

public class Task_Adapter extends RecyclerView.Adapter<Task_Adapter.MyViewHolder> {

    private Context context;
    private List<model_tomorrow_task> data;

    public Task_Adapter(Context context, List<model_tomorrow_task> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.item_subject_tomorrow , parent , false);
        return new MyViewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.task.setText(data.get(position).getTask());
        holder.subject.setText(data.get(position).getSubject());
        holder.time.setText(data.get(position).getTime());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView subject;
        TextView task;
        TextView time;


        public MyViewHolder(View itemView){
            super(itemView);

            subject = (TextView) itemView.findViewById(R.id.subject_name);
            task = (TextView) itemView.findViewById(R.id.subject_task);
            time = (TextView) itemView.findViewById(R.id.time);

        }

    }
}
