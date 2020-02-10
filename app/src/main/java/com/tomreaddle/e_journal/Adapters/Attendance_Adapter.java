package com.tomreaddle.e_journal.Adapters;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tomreaddle.e_journal.API.Model.AttendanceData;
import com.tomreaddle.e_journal.API.Model.TeacherData;
import com.tomreaddle.e_journal.Attendance;
import com.tomreaddle.e_journal.R;

import java.util.List;

public class Attendance_Adapter extends RecyclerView.Adapter<Attendance_Adapter.MyViewHolder>{

    Context context;
    List<AttendanceData> data;
    AlertDialog alertDialog;
    AlertDialog.Builder builder;


    public Attendance_Adapter(Context context, List<AttendanceData> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater= LayoutInflater.from(context);
        view = inflater.inflate(R.layout.item_attendance, parent, false);
        return new MyViewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {


        holder.time.setText(data.get(position).getTime());
        holder.subject.setText(data.get(position).getSubject());
        holder.date.setText(data.get(position).getDate());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView time;
        TextView date;
        TextView subject;

        public MyViewHolder(@NonNull final View itemView) {
            super(itemView);

            time = itemView.findViewById(R.id.time);
            subject = itemView.findViewById(R.id.subject);
            date = itemView.findViewById(R.id.date);


        }
    }
}
