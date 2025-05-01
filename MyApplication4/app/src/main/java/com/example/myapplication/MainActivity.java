package com.example.myapplication;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import static androidx.cursoradapter.widget.CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cursoradapter.widget.SimpleCursorAdapter;
// MainActivity.java avec commentaires ligne par ligne

public class MainActivity extends AppCompatActivity {
    // Déclaration des champs de saisie (description, prix, code produit)
    EditText d1, d2, d3;

    // ListView pour afficher la liste des produits
    ListView lsv;

    // Boutons pour ajouter, modifier, supprimer
    Button b1, b2, b4;

    // Instance de la classe produit pour accéder aux opérations SQLite
    Produit p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Lier cette activité au layout XML

        // Lier les vues XML aux objets Java
        d1 = findViewById(R.id.edi1); // description
        d2 = findViewById(R.id.edi2); // prix
        d3 = findViewById(R.id.edi3); // code produit
        lsv = findViewById(R.id.lsv); // ListView

        // Boutons
        b1 = findViewById(R.id.bt2); // bouton Ajouter
        b2 = findViewById(R.id.bt3); // bouton Modifier
        b4 = findViewById(R.id.bt1); // bouton Supprimer

        // Initialiser la classe produit avec le contexte de l'activité
        p = new Produit(this);

        // Rafraîchir la liste des produits dès l'ouverture de l'activité
        actualiser();

        // ==================== Bouton Ajouter ====================
        b1.setOnClickListener(view -> {
            String codeStr = d3.getText().toString();
            String description = d1.getText().toString();
            String prix = d2.getText().toString();

            // Vérifier que tous les champs sont remplis
            if (codeStr.isEmpty() || description.isEmpty() || prix.isEmpty()) {
                Toast.makeText(MainActivity.this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
            } else {
                // Insérer le produit dans la base
                int code = Integer.parseInt(codeStr);
                p.insertdt(code, description, prix);
                actualiser(); // Mettre à jour la ListView

                // Réinitialiser les champs
                d1.setText(null);
                d2.setText(null);
                d3.setText(null);
            }
        });

        // ==================== Bouton Modifier ====================
        b2.setOnClickListener(view -> {
            String codeStr = d3.getText().toString();
            String description = d1.getText().toString();
            String prix = d2.getText().toString();

            // Vérifier que tous les champs sont remplis
            if (codeStr.isEmpty() || description.isEmpty() || prix.isEmpty()) {
                Toast.makeText(MainActivity.this, "Veuillez remplir tous les champs pour modifier", Toast.LENGTH_SHORT).show();
            } else {
                // Modifier le produit dans la base
                int code = Integer.parseInt(codeStr);
                p.update(code, description, prix);
                actualiser();

                d1.setText(null);
                d2.setText(null);
                d3.setText(null);
            }
        });

        // ==================== Bouton Supprimer ====================
        b4.setOnClickListener(view -> {
            String codeStr = d3.getText().toString();

            // Vérifier que le champ code est rempli
            if (codeStr.isEmpty()) {
                Toast.makeText(MainActivity.this, "Veuillez saisir un code à supprimer", Toast.LENGTH_SHORT).show();
            } else {
                // Supprimer le produit de la base
                int code = Integer.parseInt(codeStr);
                p.delete(code);
                actualiser();

                d3.setText(null);
            }
        });
    }

    // Méthode pour actualiser le contenu du ListView avec les données de la base
    public void actualiser() {
        // Créer un adaptateur basé sur un curseur, pour lier la base de données au ListView
        SimpleCursorAdapter adap = new SimpleCursorAdapter(
                getApplicationContext(), // contexte
                android.R.layout.simple_list_item_2, // layout par défaut avec deux TextView
                p.data(), // données retournées depuis la base (Cursor)
                new String[]{"_id", "description"}, // colonnes à afficher00
                new int[]{android.R.id.text1, android.R.id.text2}, // où afficher les données
                0  // flags (0 par défaut)
                //   0 : tu gères manuellement les changements de données (pas d'observateur automatique)
                //   FLAG_REGISTER_CONTENT_OBSERVER : utile si tu veux que ton ListView se mette à jour automatiquement quand les données changent

        );
        lsv.setAdapter(adap); // lier l’adaptateur au ListView
    }
}