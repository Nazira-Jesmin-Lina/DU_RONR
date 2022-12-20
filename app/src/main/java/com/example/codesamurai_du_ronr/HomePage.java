package com.example.codesamurai_du_ronr;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomePage extends AppCompatActivity {
    AppCompatButton map;
    AppCompatButton prop_map;
    AppCompatButton create_prop;
    AppCompatButton update_prop;
    AppCompatButton all_prop;
    AppCompatButton approve_prop;
    AppCompatButton create_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        map=findViewById(R.id.btn_map);
        prop_map=findViewById(R.id.btn_Proposal_map);
        create_prop=findViewById(R.id.btn_prop_create);
        update_prop=findViewById(R.id.btn_update_prop);
        all_prop=findViewById(R.id.btn_all_prop);
        approve_prop=findViewById(R.id.btn_approve_prop);
        create_user=findViewById(R.id.btn_create_user);

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomePage.this,MapActivity.class);
                startActivity(intent);
            }
        });







    }
}