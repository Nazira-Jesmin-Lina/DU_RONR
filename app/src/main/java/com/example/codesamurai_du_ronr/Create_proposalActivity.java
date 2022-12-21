package com.example.codesamurai_du_ronr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.codesamurai_du_ronr.OOP.Proposals;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

public class Create_proposalActivity extends AppCompatActivity {
    EditText name,loc,lat,lang,exec,cost,timespan,goal,project_id,proposal_date;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_proposal);
        getSupportActionBar().hide();

        Proposals proposal=new Proposals();

        button=findViewById(R.id.button);

        name=findViewById(R.id.name_fld);
        loc=findViewById(R.id.loc);
        exec=findViewById(R.id.execc);
        lat=findViewById(R.id.lati);
        lang=findViewById(R.id.longi);
        cost=findViewById(R.id.coxtt);
        timespan=findViewById(R.id.timespan);
        goal=findViewById(R.id.goall);
        project_id=findViewById(R.id.proj_id);
        proposal_date=findViewById(R.id.prop_date);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                proposal.setName(name.getText().toString());
                proposal.setLocation(loc.getText().toString());
                proposal.setLatitude(Double.parseDouble(lat.getText().toString()));
                proposal.setLongitude(Double.parseDouble(lang.getText().toString()));
                proposal.setExec(exec.getText().toString());
                proposal.setCost(Double.parseDouble(cost.getText().toString()));
                proposal.setTimespan(Double.parseDouble(timespan.getText().toString()));
                proposal.setGoal(goal.getText().toString());
                proposal.setProposal_date(proposal_date.getText().toString());
                proposal.setProject_id(project_id.getText().toString());


                FirebaseDatabase.getInstance().getReference().child("data").child("Proposals").child(proposal.getProject_id()).setValue(proposal).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(Create_proposalActivity.this,"Proposal Created", Toast.LENGTH_LONG).show();
                        name.setText("");
                        loc.setText("");
                        lat.setText("");
                        lang.setText("");
                        exec.setText("");
                        cost.setText("");
                        timespan.setText("");
                        goal.setText("");
                        project_id.setText("");
                        proposal_date.setText("");
                    }
                });
            }
        });

//        proposal.setName(name.getText().toString());
//        proposal.setLocation(loc.getText().toString());
//        proposal.setLatitude(Double.parseDouble(lat.getText().toString()));
//        proposal.setLongitude(Double.parseDouble(lang.getText().toString()));
//        proposal.setExec(exec.getText().toString());
//        proposal.setCost(Double.parseDouble(cost.getText().toString()));
//        proposal.setTimespan(Double.parseDouble(timespan.getText().toString()));
//        proposal.setGoal(goal.getText().toString());
//        proposal.setProposal_date(proposal_date.getText().toString());
//        proposal.setProject_id(project_id.getText().toString());
//
//        FirebaseDatabase.getInstance().getReference().child("data").setValue(null);
//        FirebaseDatabase.getInstance().getReference().child("data").child("Proposals").child(proposal.getProject_id()).setValue(proposal).addOnSuccessListener(new OnSuccessListener<Void>() {
//            @Override
//            public void onSuccess(Void unused) {
//
//            }
//        });

    }
}