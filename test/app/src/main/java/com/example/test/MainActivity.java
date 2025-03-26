package com.example.test;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText edtNombre1, edtNombre2;
    private Button btnSomme, btnAnnuler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Liaison avec l'interface XML
        edtNombre1 = findViewById(R.id.edtNombre1);
        edtNombre2 = findViewById(R.id.edtNombre2);
        btnSomme = findViewById(R.id.btnSomme);
        btnAnnuler = findViewById(R.id.btnAnnuler);

        // Événement pour le bouton SOMME
        btnSomme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculerSomme();
            }
        });

        // Événement pour le bouton ANNULER
        btnAnnuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reinitialiserChamps();
            }
        });
    }

    // Fonction pour calculer la somme
    private void calculerSomme() {
        String valeur1 = edtNombre1.getText().toString();
        String valeur2 = edtNombre2.getText().toString();

        if (!valeur1.isEmpty() && !valeur2.isEmpty()) {
            try {
                int nombre1 = Integer.parseInt(valeur1);
                int nombre2 = Integer.parseInt(valeur2);
                int somme = nombre1 + nombre2;
                Toast.makeText(this, "Résultat : " + somme, Toast.LENGTH_LONG).show();
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Veuillez entrer des nombres valides", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Veuillez remplir les deux champs", Toast.LENGTH_SHORT).show();
        }
    }

    // Fonction pour réinitialiser les champs
    private void reinitialiserChamps() {
        edtNombre1.setText("");
        edtNombre2.setText("");
    }
}
