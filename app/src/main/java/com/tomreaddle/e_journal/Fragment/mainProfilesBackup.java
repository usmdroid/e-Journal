package com.tomreaddle.e_journal.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tomreaddle.e_journal.API.Model.InfoData;
import com.tomreaddle.e_journal.DB.DBHelper;
import com.tomreaddle.e_journal.MainActivity;
import com.tomreaddle.e_journal.R;
import com.tomreaddle.e_journal.Services.MySharedPreferencesData;
import com.tomreaddle.e_journal.add_profile;

import java.util.ArrayList;
import java.util.List;

public class mainProfilesBackup extends Fragment {

    RecyclerView recyclerView;
    TextView name , info_class , info_school;
    ImageView image;
    List<InfoData> list;
    Button add;
    DBHelper dbHelper;
    String log = "CallBack";


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profiles_backup, null);

        name = view.findViewById(R.id.name);
        info_class = view.findViewById(R.id.info_class);
        info_school = view.findViewById(R.id.info_school);
        image = view.findViewById(R.id.picture);
        add = view.findViewById(R.id.add_profile_button);

        MySharedPreferencesData mySharedPreferences = new MySharedPreferencesData(view.getContext());
        name.setText(mySharedPreferences.getNameProfile());
        info_school.setText(mySharedPreferences.getSchoolProfile());
        info_class.setText(mySharedPreferences.getClassProfile());

        list = new ArrayList<>();

        recyclerView = view.findViewById(R.id.rec_profiles);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

//
//                ApiService api = RetrofitClientInfo.getApiService();
//                Call<InfoData> call = api.getInfo();
//                call.enqueue(new Callback<InfoData>() {
//                    @Override
//                    public void onResponse(Call<InfoData> call, Response<InfoData> response) {
//                        if (response.isSuccessful()) {
//                            InfoData item = response.body();
//                            list.add(response.body());
//                            Toast.makeText(getContext(), item.getSchool_name(), Toast.LENGTH_SHORT).show();
//                            Profiles_Adapter profiles_adapter = new Profiles_Adapter(view.getContext() , list);
//                            recyclerView.setAdapter(profiles_adapter);
//                        } else {
//                            Toast.makeText(getContext(), "Response kemadi", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<InfoData> call, Throwable t) {
//                        Toast.makeText(getContext(), "Oshibka", Toast.LENGTH_SHORT).show();
//                    }
//                });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mainActivity = new MainActivity();
                mainActivity.finish();
                startActivity(new Intent(v.getContext() , add_profile.class));
            }
        });

        return view;
    }
}
