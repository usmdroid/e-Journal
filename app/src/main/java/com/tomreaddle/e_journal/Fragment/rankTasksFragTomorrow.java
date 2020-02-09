package com.tomreaddle.e_journal.Fragment;

import java.util.List;
import android.os.Bundle;
import android.view.View;
import java.util.ArrayList;
import android.view.ViewGroup;
import com.tomreaddle.e_journal.R;
import android.view.LayoutInflater;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.tomreaddle.e_journal.Adapters.Task_Adapter;
import androidx.recyclerview.widget.GridLayoutManager;
import com.tomreaddle.e_journal.Models.model_tomorrow_task;

public class rankTasksFragTomorrow extends Fragment {

    View view;
    List<model_tomorrow_task> list;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.rank_frag_tomorrow , null);

        list = new ArrayList<>();

        list.add(new model_tomorrow_task("Biologiya" , "Sut emizuvchilar va ularning yashash tarzi"));
        list.add(new model_tomorrow_task("Biologiya" , "Sut emizuvchilar va ularning yashash tarzi"));
        list.add(new model_tomorrow_task("Biologiya" , "Sut emizuvchilar va ularning yashash tarzi"));
        list.add(new model_tomorrow_task("Biologiya" , "Sut emizuvchilar va ularning yashash tarzi"));
        list.add(new model_tomorrow_task("Biologiya" , "Sut emizuvchilar va ularning yashash tarzi"));
        list.add(new model_tomorrow_task("Biologiya" , "Sut emizuvchilar va ularning yashash tarzi"));

        RecyclerView recyclerView = view.findViewById(R.id.RecTasks);
        Task_Adapter adapter = new Task_Adapter(view.getContext() , list);
        recyclerView.setLayoutManager(new GridLayoutManager(view.getContext() , 3));
        recyclerView.setAdapter(adapter);

        return view;
    }

}
