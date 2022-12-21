package com.example.codesamurai_du_ronr;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.codesamurai_du_ronr.OOP.Projects;
import com.example.codesamurai_du_ronr.OOP.Proposals;
import com.example.codesamurai_du_ronr.OOP.User;
import com.example.codesamurai_du_ronr.databinding.ActivityCommentBinding;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Date;

public class commentActivity extends AppCompatActivity {


    ArrayList<Comment> list=new ArrayList<>();
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
        String type=b.getString("type");
        String id=b.getString("id");
        System.out.println("name "+name);
        if(type.equals("project"))
        {
            FirebaseDatabase.getInstance().getReference().child("data").child("Projects").addValueEventListener(new ValueEventListener() {
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

        }
        else
        {
            FirebaseDatabase.getInstance().getReference().child("data").child("Proposals").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {

                    for(DataSnapshot dataSnapshot: snapshot.getChildren())
                    {
                        Proposals tmp=dataSnapshot.getValue(Proposals.class);
                        if(tmp.getName().equals(name))
                        {
                            binding.proName.setText(tmp.getName());
                            binding.locationn.setText(tmp.getLocation());
                            binding.execc.setText(tmp.getExec());
                            binding.goall.setText(tmp.getGoal());
                            binding.coxtt.setText(String.valueOf(tmp.getCost()));
                            binding.timesppan.setText(String.valueOf(tmp.getTimespan()));
                            binding.projid.setText(tmp.getProject_id());
                            binding.startdate.setText(tmp.getProposal_date());
                            binding.textView.setText("Proposal Date :");
                            binding.textView7.setVisibility(View.GONE);
                            binding.actualcostt.setVisibility(View.GONE);

                        }


                    }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }

        binding.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Comment comment=new Comment();
                comment.setCommentText(binding.addcmnttext.getText().toString());
                comment.setCommentedAt(new Date().getTime());
                FirebaseDatabase.getInstance().getReference().child("login").child("User").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        User user=snapshot.getValue(User.class);
                        comment.setCommentedby(user.getName());
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

                FirebaseDatabase.getInstance().getReference().child("comments").child(name).push().setValue(comment).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        binding.addcmnttext.setText("");
                        Toast.makeText(commentActivity.this, "Commented", Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });


        Comment_adapter comment_adapter=new Comment_adapter(this,list);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        binding.cmmtRv.setLayoutManager(linearLayoutManager);
        binding.cmmtRv.setAdapter(comment_adapter);
        TextView idd=findViewById(R.id.projid);
        FirebaseDatabase.getInstance().getReference().child("comments").child(name)
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        list.clear();
                        for(DataSnapshot dataSnapshot: snapshot.getChildren())
                        {
                            Comment comment=dataSnapshot.getValue(Comment.class);
                            list.add(comment);
                        }
                        comment_adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        System.out.println("hoy ni" + error.getMessage());

                    }
                });

    }
}