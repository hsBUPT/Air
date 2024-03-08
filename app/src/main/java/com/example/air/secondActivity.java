package com.example.air;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class secondActivity extends AppCompatActivity {
    private EditText userEdt,passEdt;
    private Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);

        initView();
        setVariable();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void initView(){
        userEdt = findViewById(R.id.editTextText2);
        passEdt = findViewById(R.id.editTextText);
        loginBtn = findViewById(R.id.loginBtn);
    }

    private void setVariable(){
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (userEdt.getText().toString().isEmpty()||passEdt.getText().toString().isEmpty()){
                    Toast.makeText(secondActivity.this,"Please fill the login form",Toast.LENGTH_SHORT).show();
                } else if (userEdt.getText().toString().equals("admin")&& passEdt.getText().toString().equals("group43")) {
                    startActivity(new Intent(secondActivity.this,IndexActivity.class));
                }
            }
        });
    }
}