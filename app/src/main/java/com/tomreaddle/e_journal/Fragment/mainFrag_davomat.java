package com.tomreaddle.e_journal.Fragment;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.r0adkll.slidr.Slidr;
import com.tomreaddle.e_journal.R;

public class mainFrag_davomat extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main_davomat);

        int primary = getResources().getColor(R.color.colorAccentDark);
        int secondary = getResources().getColor(R.color.colorPrimaryDark);

        Slidr.attach(this , primary , secondary );
    }
}
