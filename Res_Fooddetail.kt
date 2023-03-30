package com.example.sharedpreference.apiretrofit.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "FoodDetail")
data class Res_Fooddetail(
    @PrimaryKey(autoGenerate = false) var id: Int? = null,
    var foodId: Int? = null,
    var foodName: String = "",
    var description: String = "",
    var foodImage: String = "",
    var restaurantId1: Int = 0
) : Serializable
