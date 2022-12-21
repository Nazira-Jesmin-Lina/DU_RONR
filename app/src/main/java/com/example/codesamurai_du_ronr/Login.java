package com.example.codesamurai_du_ronr;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    AppCompatButton login;
    TextView signup;
    EditText email,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login=findViewById(R.id.login_bttn);
        signup=findViewById(R.id.sign_up_click);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        getSupportActionBar().hide();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s_email = email.getText().toString();
                String s_pass = password.getText().toString();
//                Intent intent=new Intent(Login.this,HomePage.class);
//                startActivity(intent);
                if (s_pass.isEmpty()) password.setError("Password field can't be empty.");
                else {
                    FirebaseAuth.getInstance().signInWithEmailAndPassword(s_email, s_pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                                 if(task.isSuccessful())
                                 {
                                     Intent intent=new Intent(Login.this,HomePage.class);
                                     startActivity(intent);
                                 }
                                 else
                                 {
                                     Toast.makeText(getApplicationContext(),"Error occured",Toast.LENGTH_SHORT);

                                 }
                        }
                    });
                }
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Login.this,SignUp.class);
                startActivity(intent);
            }
        });
    }
}