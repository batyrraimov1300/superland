package com.example.superland.Data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.superland.Model.SuperDB;

@Database(entities = {SuperDB.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract FoodDao foodDao();
}
