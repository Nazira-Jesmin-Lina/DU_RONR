package com.example.codesamurai_du_ronr;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.codesamurai_du_ronr.OOP.Cord;
import com.example.codesamurai_du_ronr.OOP.Projects;
import com.example.codesamurai_du_ronr.OOP.Proposals;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Project_ListActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ProjectAdapter adapter;
    ArrayList<Project_name> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_list);

        recyclerView = findViewById(R.id.recyclerview);
        list = new ArrayList<>();

        Bundle b=getIntent().getExtras();
        Double lat=b.getDouble("lat");
        Double lng=b.getDouble("lng");
        String type=b.getString("type");

        Toast.makeText(this, lat+" "+lng, Toast.LENGTH_SHORT).show();

        if(type.equals("project"))
        {
            FirebaseDatabase.getInstance().getReference().child("Projects").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    for (DataSnapshot dataSnapshot: snapshot.getChildren())
                    {
                        Projects projects=dataSnapshot.getValue(Projects.class);
                        System.out.println(projects.name+" hi");
                        if(projects.latitude.toString().equals(lat.toString())&&projects.longitude.toString().equals(lng.toString())){
                            System.out.println("Milse");
                            list.add(new Project_name(projects.name));
                        }

                    }
                    adapter = new ProjectAdapter(getApplicationContext(),list);
                    LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false);
                    recyclerView.setLayoutManager(llm);
                    recyclerView.setAdapter(adapter);


                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });

        }
        else
        {
            FirebaseDatabase.getInstance().getReference().child("Proposals").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    for (DataSnapshot dataSnapshot: snapshot.getChildren())
                    {
                        Proposals proposals=dataSnapshot.getValue(Proposals.class);
                        if(proposals.latitude.toString().equals(lat.toString())&&proposals.longitude.toString().equals(lng.toString())){
                            System.out.println("Milse");
                            list.add(new Project_name(proposals.name));
                        }

                    }
                    adapter = new ProjectAdapter(getApplicationContext(),list);
                    LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false);
                    recyclerView.setLayoutManager(llm);
                    recyclerView.setAdapter(adapter);


                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }








    }
}