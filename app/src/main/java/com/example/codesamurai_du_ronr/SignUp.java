package com.example.codesamurai_du_ronr;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.codesamurai_du_ronr.OOP.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {

    EditText name,email,p1,p2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getSupportActionBar().hide();

        name=findViewById(R.id.sup_name);
        email=findViewById(R.id.sup_email);
        p1=findViewById(R.id.sup_pass);
        p2=findViewById(R.id.sup_pass_cnfrm);

        Button sgnup=findViewById(R.id.sup_button);

        sgnup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s_email = email.getText().toString();
                String s_pass1 = p1.getText().toString();
                String s_pass2 = p2.getText().toString();
                String s_name = name.getText().toString();

                if (s_name.isEmpty()) name.setError("Name field can't be empty");
                else if (s_pass1.isEmpty()) p1.setError("Password field can't be empty.");
                else if (s_pass1.length() < 6) p1.setError("Password length must be at least 6");
                else if (!s_pass1.equals(s_pass2)) p2.setError("Password didn't match");
                else {
                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(s_email, s_pass1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful())
                            {
                                User user=new User();
                                user.setName(s_name);
                                user.setEmail(s_email);
                                user.setRole("app");

                                FirebaseDatabase.getInstance().getReference().child("User").child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                                .setValue(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                            @Override
                                            public void onSuccess(Void unused) {

                                            }
                                        });
                               Toast.makeText(getApplicationContext(),"Account Created",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });



                }
            }
        });









    }
}