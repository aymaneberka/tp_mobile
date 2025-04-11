package com.example.tp3;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> sr=new ArrayList<String>();
    ListView listV;
    ArrayAdapter<String> adapter;
    EditText input;
    Button add;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listV=findViewById(R.id.list_contacts);
        input=findViewById(R.id.et_new_contact);
        add=findViewById(R.id.btn_add);
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,sr);
        listV.setAdapter(adapter);

        add.setOnClickListener(v->{
            sr.add(input.getText().toString());
            adapter.notifyDataSetChanged();
            input.setText("");
        });

        listV.setOnItemClickListener((parent, view, position, id) -> {
            String selectedItem = sr.get(position);
            Toast.makeText(this, "Selected item: " + selectedItem, Toast.LENGTH_SHORT).show();
        });
    };
}
