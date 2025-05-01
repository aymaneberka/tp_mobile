package com.example.tp51;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "images")
public class ImageEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String caption;
    public int imageResId;

    public ImageEntity(String caption, int imageResId) {
        this.caption = caption;
        this.imageResId = imageResId;
    }
}