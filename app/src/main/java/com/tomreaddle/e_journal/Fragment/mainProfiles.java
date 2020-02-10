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

public class mainProfiles extends Fragment {

    RecyclerView recyclerView;
    TextView name , info_class , info_school , school , adress , adress_full , adress_mail , director , phone;
    ImageView image;
    List<InfoData> list;
    DBHelper dbHelper;
    String log = "CallBack";


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profiles, null);

        name = view.findViewById(R.id.name);
        info_class = view.findViewById(R.id.info_class);
        info_school = view.findViewById(R.id.info_school);
        image = view.findViewById(R.id.picture);
        school = view.findViewById(R.id.school);
        adress = view.findViewById(R.id.adress);
        adress_full = view.findViewById(R.id.adress_full);
        adress_mail = view.findViewById(R.id.mail);
        director = view.findViewById(R.id.director);
        phone = view.findViewById(R.id.phone);
        image = view.findViewById(R.id.image);

//        MySharedPreferencesData mySharedPreferences = new MySharedPreferencesData(view.getContext());
//        name.setText(mySharedPreferences.getNameProfile());
//        info_school.setText(mySharedPreferences.getSchoolProfile());
//        info_class.setText(mySharedPreferences.getClassProfile());
//        school.setText(mySharedPreferences.getSchoolProfile());
//        adress.setText(mySharedPreferences.getAdressProfile());
//        adress_full.setText(mySharedPreferences.getAdressFullProfile());
//        adress_mail.setText(mySharedPreferences.getAdressMailProfile());
//        director.setText(mySharedPreferences.getDirectorProfile());
//        phone.setText(mySharedPreferences.getPhoneProfile());



        return view;
    }
}
