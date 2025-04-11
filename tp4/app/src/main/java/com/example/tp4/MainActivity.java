package com.example.tp4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText d1,d2;
    Button b1,b2;
    TextView t1,t2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        d1=(EditText)findViewById(R.id.login);
        d2=(EditText)findViewById(R.id.pwd);
        b1=(Button)findViewById(R.id.bt);
        b2=(Button)findViewById(R.id.bt2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String log=d1.getText().toString();
                String pwd=d2.getText().toString();
                Intent in=new
                        Intent(getApplicationContext(),Activity2.class);
                Bundle bd=new Bundle();
                bd.putString("username",log);
                bd.putString("password",pwd);
                in.putExtras(bd);
                startActivity(in);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(getApplicationContext(),Activity3.class);
                startActivity(in);
            }
        });
    }
}