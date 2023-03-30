package com.example.sharedpreference.apiretrofit.database;


import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.sharedpreference.apiretrofit.model.Res_Fooddetail;
import com.example.sharedpreference.apiretrofit.model.Res_detail;
import com.example.sharedpreference.apiretrofit.utils.Res_FooddetailDao;
import com.example.sharedpreference.apiretrofit.utils.Res_detailDao;

@Database(entities = {Res_detail.class, Res_Fooddetail.class}, version = 1, exportSchema = false)
public abstract class FoodDetailDatabase extends RoomDatabase {

    private static FoodDetailDatabase Instance;

    public static FoodDetailDatabase getInstance(Context context) {
        if (Instance == null) {

            Instance = Room.databaseBuilder(context.getApplicationContext(),
                    FoodDetailDatabase.class, "FOOD DATA")
                    .allowMainThreadQueries()
                    .build();
        }
        return Instance;
    }

    public abstract Res_detailDao res_detailDao();
    public abstract Res_FooddetailDao res_fooddetailDao();
}
