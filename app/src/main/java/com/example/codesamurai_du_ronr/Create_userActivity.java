package com.example.codesamurai_du_ronr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class Create_userActivity extends AppCompatActivity {

    private final String[] nameOfRoll = new String[]{
            "System Admin","MOP","EXEC","APP"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);
        getSupportActionBar().hide();

        AutoCompleteTextView role_name = findViewById(R.id.role);
        ArrayAdapter<String> adapter = new
                ArrayAdapter<String>(this,
                R.layout.list_items,R.id.text_view_list_item, nameOfRoll);
        role_name.setAdapter(adapter);
        role_name.setAdapter(adapter);

        };
}