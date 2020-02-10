package com.tomreaddle.e_journal.Adapters;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tomreaddle.e_journal.API.Model.InfoData;
import com.tomreaddle.e_journal.API.Model.TeacherData;
import com.tomreaddle.e_journal.R;

import java.util.List;

public class Teachers_Adapter extends RecyclerView.Adapter<Teachers_Adapter.MyViewHolder>{

    Context context;
    List<TeacherData> data;
    AlertDialog alertDialog;
    AlertDialog.Builder builder;


    public Teachers_Adapter(Context context, List<TeacherData> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater= LayoutInflater.from(context);
        view = inflater.inflate(R.layout.item_teacher, parent, false);
        return new MyViewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {


        holder.name.setText(data.get(position).getF_name() + " " + data.get(position).getL_name());
        holder.subject.setText(data.get(position).getSubject_name());
        holder.phone.setText(data.get(position).getPhone());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        TextView phone;
        TextView subject;

        public MyViewHolder(@NonNull final View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            subject = itemView.findViewById(R.id.subject);
            phone = itemView.findViewById(R.id.phone);


        }
    }
}
