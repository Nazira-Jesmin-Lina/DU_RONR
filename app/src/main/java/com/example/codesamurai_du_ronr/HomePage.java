package com.example.codesamurai_du_ronr;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.codesamurai_du_ronr.OOP.Agencies;
import com.example.codesamurai_du_ronr.OOP.Components;
import com.example.codesamurai_du_ronr.OOP.Constraints;
import com.example.codesamurai_du_ronr.OOP.Projects;
import com.example.codesamurai_du_ronr.OOP.Proposals;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class HomePage extends AppCompatActivity {
    ConstraintLayout map;
    ConstraintLayout prop_map;
    ConstraintLayout create_prop;
    ConstraintLayout update_prop;
    ConstraintLayout all_prop;
    ConstraintLayout approve_prop;
    ConstraintLayout create_user;
    Button up;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        map=findViewById(R.id.btn_map);
        prop_map=findViewById(R.id.btn_proposal_map);
        create_prop=findViewById(R.id.btn_prop_create);
        update_prop=findViewById(R.id.btn_update_prop);
        all_prop=findViewById(R.id.btn_all_prop);
        approve_prop=findViewById(R.id.btn_approve_prop);
        create_user=findViewById(R.id.btn_create_user);
        up=findViewById(R.id.dbms);

        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase.getInstance().getReference().setValue(null);
                Data data=new Data();
                ArrayList<Projects> pp=data.get_projects(getApplicationContext());
                for(Projects tmp: pp)
                {
                    FirebaseDatabase.getInstance().getReference().child("Projects").child(tmp.getProject_id()).setValue(tmp).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {

                        }
                    });

                }
                ArrayList<Proposals> p1=data.get_proposals(getApplicationContext());
                {
                    for(Proposals tmp: p1)
                    {
                        FirebaseDatabase.getInstance().getReference().child("Proposals").child(tmp.getProject_id()).setValue(tmp).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {

                            }
                        });

                    }

                }

                ArrayList<Agencies> p2=data.get_agencies(getApplicationContext());
                {
                    for(Agencies tmp: p2)
                    {
                        FirebaseDatabase.getInstance().getReference().child("Agencies").child(tmp.code).setValue(tmp).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {

                            }
                        });

                    }

                }

                ArrayList<Constraints> p3=data.get_constraints(getApplicationContext());
                {
                    for(Constraints tmp: p3)
                    {
                        FirebaseDatabase.getInstance().getReference().child("Constraints").child(tmp.getCode()+tmp.getConstraint_type()).setValue(tmp).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {

                            }
                        });

                    }

                }

                ArrayList<Components> p4=data.get_components(getApplicationContext());
                {
                    for(Components tmp: p4)
                    {
                        FirebaseDatabase.getInstance().getReference().child("Components").child(tmp.getComponent_id()).setValue(tmp).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {

                            }
                        });

                    }

                }





            }
        });

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomePage.this,fragmentActivity.class);
                intent.putExtra("val","project");
                startActivity(intent);
            }
        });

        prop_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomePage.this,fragmentActivity.class);
                intent.putExtra("val","prop");
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