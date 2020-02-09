package com.tomreaddle.e_journal.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tomreaddle.e_journal.Adapters.Profiles_Adapter;
import com.tomreaddle.e_journal.Models.model_profiles;
import com.tomreaddle.e_journal.R;
import com.tomreaddle.e_journal.add_profile;

import java.util.ArrayList;
import java.util.List;

public class mainProfiles extends Fragment {

    RecyclerView recyclerView;
    TextView name , info;
    ImageView image;
    List<model_profiles> list;
    Button add;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profiles, null);

        name = view.findViewById(R.id.name);
        info = view.findViewById(R.id.info);
        image = view.findViewById(R.id.picture);
        add = view.findViewById(R.id.add_profile_button);

        list = new ArrayList<>();


        list.add(new model_profiles("https://google.com" , "Usmanov Amir" , "298" , "1-A"));

        recyclerView = view.findViewById(R.id.rec_profiles);
        Profiles_Adapter profiles_adapter = new Profiles_Adapter(view.getContext() , list);
        recyclerView.setLayoutManager(new GridLayoutManager(view.getContext() , 2));
        recyclerView.setAdapter(profiles_adapter);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext() , add_profile.class));
            }
        });

        return view;
    }
}
