package com.example.superland;

import android.app.Application;

import androidx.room.Room;

import com.example.superland.Data.AppDatabase;
import com.example.superland.Data.FoodDao;

public class App extends Application {

    private AppDatabase database;
    private FoodDao foodDao;

    private static App instance;

    public static App getInstance() {
        return instance;
    }


    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;

        database = Room.databaseBuilder(getApplicationContext(),AppDatabase.class, "app-db-name")
                .allowMainThreadQueries()
                .build();

        foodDao = database.foodDao();
    }


    public AppDatabase getDatabase() {
        return database;
    }

    public void setDatabase(AppDatabase database) {
        this.database = database;
    }

    public FoodDao getNoteDao() {
        return foodDao;
    }

    public void setNoteDao(FoodDao noteDao) {
        this.foodDao = foodDao;
    }
}
