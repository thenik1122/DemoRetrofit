package com.example.sharedpreference.apiretrofit.utils

import androidx.room.*
import com.example.sharedpreference.apiretrofit.model.Res_Fooddetail

@Dao
interface Res_FooddetailDao {

    @Insert
    fun insert(resFooddetail: Res_Fooddetail)

    @Update
    fun update(resFooddetail: Res_Fooddetail)

    @Delete
    fun delete(resFooddetail: Res_Fooddetail)

    @Query("select * from FoodDetail where restaurantId1 = :id_test")
    fun getAll(id_test: Int): List<Res_Fooddetail>?

}