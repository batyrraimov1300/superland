package com.example.superland.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;

@Entity
public class SuperDB {
    @PrimaryKey(autoGenerate = true)
    public int foodId;
    @ColumnInfo(name = "imageFood")
    public String imageFood;
    @ColumnInfo(name = "titleFood")
    public String titleFood;
    @ColumnInfo(name = "numberFood")
    public int numberFood;

    public SuperDB() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SuperDB superDB = (SuperDB) o;
        return foodId == superDB.foodId && numberFood == superDB.numberFood && imageFood.equals(superDB.imageFood) && titleFood.equals(superDB.titleFood);
    }

    @Override
    public int hashCode() {
        return Objects.hash(foodId, imageFood, titleFood, numberFood);
    }
}
