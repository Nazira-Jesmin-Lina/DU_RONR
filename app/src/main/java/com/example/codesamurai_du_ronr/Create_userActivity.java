package com.example.codesamurai_du_ronr;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.codesamurai_du_ronr.OOP.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Create_userActivity extends AppCompatActivity {

    Button b;
    private final String[] nameOfRoll = new String[]{
            "System Admin","MOP","EXEC","APP"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);
        getSupportActionBar().hide();
        b=findViewById(R.id.button2);

        AutoCompleteTextView role_name = findViewById(R.id.role);
        ArrayAdapter<String> adapter = new
                ArrayAdapter<String>(this,
                R.layout.list_items,R.id.text_view_list_item, nameOfRoll);
        role_name.setAdapter(adapter);
        role_name.setAdapter(adapter);

        b.setOnClickListener(new View.OnClickListener() {
            String uid="";
            @Override
            public void onClick(View view) {
                EditText email=findViewById(R.id.email_fld);
                FirebaseDatabase.getInstance().getReference().child("login").child("User").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                      for (DataSnapshot dataSnapshot: snapshot.getChildren())
                      {
                          User user=dataSnapshot.getValue(User.class);
                          if(user.getEmail().equals(email.getText()))
                          {
                              uid=dataSnapshot.getKey();
                          }
                      }

                    };

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        });




        };
}