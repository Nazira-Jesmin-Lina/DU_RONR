package com.example.codesamurai_du_ronr;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class fragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        getSupportActionBar().hide();
        Bundle b=getIntent().getExtras();
        String s=b.getString("val");
        if(s.equals("project"))
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new MapActivity()).commit();
        }
        else
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new Proposal_mapActivity()).commit();
        }

    }
}