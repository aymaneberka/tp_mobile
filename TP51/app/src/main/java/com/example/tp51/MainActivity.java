package com.example.tp51;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    private ImageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ImageAdapter();
        recyclerView.setAdapter(adapter);

        AppDatabase db = AppDatabase.getInstance(this);
        ImageDao imageDao = db.imageDao();

        // Insérer des données si la base de données est vide
        Executors.newSingleThreadExecutor().execute(() -> {
            if (imageDao.getAllImages().getValue() == null || imageDao.getAllImages().getValue().isEmpty()) {
                imageDao.insert(new ImageEntity("Image 1", R.drawable.im1));
                imageDao.insert(new ImageEntity("Image 2", R.drawable.im2));
            }
        });

        // Observer les données
        imageDao.getAllImages().observe(this, images -> adapter.setImages(images));
    }
}