package com.example.tp4;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Activity3 extends AppCompatActivity {

    private TextView textViewLogin, textViewPassword;
    private Button buttonOpenWeb, buttonCall, buttonMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);


        // Initialiser les boutons
        buttonOpenWeb = findViewById(R.id.buttonOpenWeb);
        buttonCall = findViewById(R.id.buttonCall);
        buttonMap = findViewById(R.id.buttonMap);

        // Aller sur une page Web
        buttonOpenWeb.setOnClickListener(v -> {
            Uri webpage = Uri.parse("https://www.google.com");
            Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
            startActivity(webIntent);
        });

        // Faire un appel téléphonique
        buttonCall.setOnClickListener(v -> {
            Uri number = Uri.parse("tel:0645127859");
            Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
            startActivity(callIntent);
        });

        // Ouvrir une carte
        buttonMap.setOnClickListener(v -> {
            Uri location = Uri.parse("geo:37.425239,-892.0836?z=18");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
            startActivity(mapIntent);
        });
    }
}