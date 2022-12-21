package com.example.codesamurai_du_ronr;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.codesamurai_du_ronr.OOP.Proposals;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class All_proposalActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ProjectAdapter adapter;
    ArrayList<Project_name> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_proposal);
        getSupportActionBar().hide();

        recyclerView = findViewById(R.id.RV);
        list = new ArrayList<>();

        FirebaseDatabase.getInstance().getReference().child("data").child("Proposals").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot: snapshot.getChildren())
                {
                    Proposals proposals=dataSnapshot.getValue(Proposals.class);

                        list.add(new Project_name(proposals.name));

                }
                adapter = new ProjectAdapter(getApplicationContext(),list,"proposal");
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