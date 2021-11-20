package com.example.superland.Data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.superland.Model.SuperDB;

import java.util.List;

@Dao
public interface FoodDao {
    @Query("SELECT * FROM SuperDB")
    List<SuperDB> getAll();

    @Query("SELECT * FROM SuperDB")
    LiveData<List<SuperDB>> getAllLiveData();

    @Query("SELECT * FROM SuperDB WHERE foodId IN (:foodIds)")
    List<SuperDB> loadAllByIds(int[] foodIds);

    @Query("SELECT * FROM SuperDB WHERE foodId = :foodId LIMIT 1")
    SuperDB findById(int foodId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(SuperDB SuperDB);

    @Update
    void update(SuperDB SuperDB);

    @Delete
    void delete(SuperDB SuperDB);
}
