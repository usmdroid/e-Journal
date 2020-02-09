package com.tomreaddle.e_journal.Adapters;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tomreaddle.e_journal.Models.model_profiles;
import com.tomreaddle.e_journal.R;

import java.util.List;

public class Profiles_Adapter extends RecyclerView.Adapter<Profiles_Adapter.MyViewHolder>{

    Context context;
    List<model_profiles> data;
    AlertDialog alertDialog;
    AlertDialog.Builder builder;
    String[] alertMenu = {"O'chirish"};


    public Profiles_Adapter(Context context, List<model_profiles> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater= LayoutInflater.from(context);
        view = inflater.inflate(R.layout.item_profiles, parent, false);
        return new MyViewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        Integer color_text = R.color.profile_pink , back = R.drawable.ic_item_profile_1;
        int color =  position%4;

        switch(color){
            case 0 :
                color_text = holder.itemView.getResources().getColor(R.color.profile_pink);
                back = R.drawable.ic_item_profile_1;
                break;
            case 1 :
                color_text = holder.itemView.getResources().getColor(R.color.profile_blue1);
                back = R.drawable.ic_item_profile_2;
                break;
            case 2 :
                color_text = holder.itemView.getResources().getColor(R.color.profile_blue1);
                back = R.drawable.ic_item_profile_2;
                break;
            case 3 :
                color_text = holder.itemView.getResources().getColor(R.color.profile_pink);
                back = R.drawable.ic_item_profile_1;
                break;
        }

        holder.back_item_profile.setBackgroundResource(back);
        holder.name.setTextColor(color_text);
        holder.school.setTextColor(color_text);
        holder.class_num.setTextColor(color_text);
        holder.ic_school.setColorFilter(color_text);
        holder.ic_class.setColorFilter(color_text);
        holder.url.setColorFilter(color_text);

        holder.back_item_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, data.get(position).getName()+"\n"
                        + data.get(position).getSchool() + "maktab\n"
                        + data.get(position).getClass_num() + "sinf",
                        Toast.LENGTH_SHORT).show();
            }
        });

        holder.back_item_profile.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                builder = new AlertDialog.Builder(context);
                builder.setTitle("O'chirishni xoxlaysizmi?");
                builder.setPositiveButton("Ha", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context, "O'chirildi!", Toast.LENGTH_SHORT).show();

                    }
                });
                builder.setNegativeButton("Yo'q", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                alertDialog = builder.create();
                alertDialog.show();
                return true;
            }
        });


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        ImageView url;
        ImageView ic_school;
        ImageView ic_class;
        TextView school;
        TextView class_num;
        RelativeLayout back_item_profile;

        public MyViewHolder(@NonNull final View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name_pupil);
            url = itemView.findViewById(R.id.pic_profile);
            ic_class = itemView.findViewById(R.id.ic_class);
            ic_school = itemView.findViewById(R.id.ic_school);
            school = itemView.findViewById(R.id.school_number);
            class_num = itemView.findViewById(R.id.class_num);
            back_item_profile = itemView.findViewById(R.id.back_item_profile);


        }
    }
}
