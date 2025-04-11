package com.example.tp4;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class Activity2 extends AppCompatActivity {

    private TextView textViewLogin, textViewPassword;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        textViewLogin = findViewById(R.id.textView);
        textViewPassword = findViewById(R.id.textView2);


        Intent intent = getIntent();
        String login = intent.getStringExtra("username");
        String password = intent.getStringExtra("password");


        textViewLogin.setText("Login : " + login);
        textViewPassword.setText("Mot de passe : " + password);
    }
}
