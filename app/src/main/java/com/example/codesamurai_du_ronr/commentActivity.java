package com.example.codesamurai_du_ronr;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.codesamurai_du_ronr.OOP.Projects;
import com.example.codesamurai_du_ronr.databinding.ActivityCommentBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class commentActivity extends AppCompatActivity {

    //ArrayList<Comment> list=new ArrayList<>();
    ActivityCommentBinding binding;
    TextView t1,t2,t3,t4,t5,t6,t7,t8;
    ImageView b;
    RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);



        binding= ActivityCommentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());




        Bundle b=getIntent().getExtras();
        String name=b.getString("name");
        System.out.println("name "+name);

        FirebaseDatabase.getInstance().getReference().child("Projects").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for(DataSnapshot dataSnapshot: snapshot.getChildren())
                {
                    Projects tmp=dataSnapshot.getValue(Projects.class);
                    if(tmp.getName().equals(name))
                    {
                        binding.proName.setText(tmp.getName());
                        binding.locationn.setText(tmp.getLocation());
                        binding.execc.setText(tmp.getExec());
                        binding.goall.setText(tmp.getGoal());
                        binding.coxtt.setText(String.valueOf(tmp.getCost()));
                        binding.timesppan.setText(String.valueOf(tmp.getTimespan()));
                        binding.projid.setText(tmp.getProject_id());
                        binding.startdate.setText(tmp.start_date);
                        binding.actualcostt.setText(String.valueOf(tmp.getActual_cost()));

                    }


                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

//        Comment_adapter comment_adapter=new Comment_adapter(this,list);
//        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
//        rv.setLayoutManager(linearLayoutManager);
//        rv.setAdapter(comment_adapter);

    }
}