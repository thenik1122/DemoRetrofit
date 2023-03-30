package com.example.sharedpreference.apiretrofit.utils

import androidx.room.*
import com.example.sharedpreference.apiretrofit.model.Res_detail
import com.example.sharedpreference.database.model.User

@Dao
interface Res_detailDao {

    @Insert
    fun insert(resDetail: Res_detail)

    @Update
    fun update(resDetail: Res_detail)

    @Delete
    fun delete(resDetail: Res_detail)

    @Query("select * from RestaurantDetail order by id ")
    fun getAllUser(): List<Res_detail>?
}