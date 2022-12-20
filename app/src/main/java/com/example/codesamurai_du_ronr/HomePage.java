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
                Intent intent=new Intent(HomePage.this,fragmentActivity.class);
                startActivity(intent);
            }
        });

        prop_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomePage.this,Proposal_mapActivity.class);
                startActivity(intent);
            }
        });

        create_prop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomePage.this,Create_proposalActivity.class);
                startActivity(intent);
            }
        });

        update_prop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomePage.this,Update_proposalActivity.class);
                startActivity(intent);
            }
        });


        all_prop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomePage.this,All_proposalActivity.class);
                startActivity(intent);
            }
        });

        approve_prop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomePage.this,Approve_proposalActivity.class);
                startActivity(intent);
            }
        });

        create_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomePage.this,Create_userActivity.class);
                startActivity(intent);
            }
        });



    }
}