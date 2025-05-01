package com.example.tp51;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ImageDao {
    @Insert
    void insert(ImageEntity image);

    @Query("SELECT * FROM images")
    LiveData<List<ImageEntity>> getAllImages();
}