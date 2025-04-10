package com.example.tp2;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    Etab etabUniv=new Etab();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button  saveBut= (Button) findViewById(R.id.save);
        saveBut.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText nom = (EditText) findViewById(R.id.nom);
                EditText adress = (EditText) findViewById(R.id.addr);
                EditText afficher = (EditText) findViewById(R.id.afficher);
                etabUniv.setAfficher("le nom de l'etablissement est" +
                        " " + nom.getText().toString() + "\n" + "L'adresse saisie est" +
                        " " + adress.getText().toString());
                afficher.setText(etabUniv.getAfficher());
            }

            //Toast.makeText(MainActivity.this, "Le nom de l'établissement est : " + nom + ",L'adresse saisie est : " + address, Toast.LENGTH_SHORT).show();

        });
    }
}