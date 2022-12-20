package com.example.codesamurai_du_ronr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Create_userActivity extends AppCompatActivity {

    private final String[] nameOfUniversity = new String[]{
            "System Admin","ECNEC","MOP","EXEC","APP"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);

        };
}