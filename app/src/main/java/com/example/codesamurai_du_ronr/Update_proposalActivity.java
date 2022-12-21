package com.example.codesamurai_du_ronr;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.ArrayList;

public class Update_proposalActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    EditText searchbar;
    ProjectAdapter adapter;
    ArrayList<Project_name> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_proposal);
        getSupportActionBar().hide();

        recyclerView=findViewById(R.id.RV);
        searchbar=findViewById(R.id.searchbar);

        Data data=new Data();
        data.get_prop_from_firebase();

        adapter = new ProjectAdapter(this,list,"proposal");
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(adapter);


        searchbar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                list.clear();
                ArrayList<Project_name> tmp=data.search(charSequence.toString());
                for(Project_name p: tmp)
                {
                    list.add(p);
                }
                adapter.notifyDataSetChanged();
//                if(tp==1){
//                    ArrayList<Project_name> tmp=data.filter_by_category(charSequence.toString(),getApplicationContext());
//                    list.clear();
//                    for(Project_name p: tmp)
//                    {
//                        list.add(p);
//                    }
//                    adapter.notifyDataSetChanged();
//
//                }

            }
            @Override
            public void afterTextChanged(Editable editable) {

            }
        });



    }
}