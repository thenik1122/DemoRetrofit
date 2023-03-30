package com.example.sharedpreference.apiretrofit.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "RestaurantDetail")
data class Res_detail(
    @PrimaryKey(autoGenerate = false) var id: Int? = null,
    var restaurantName: String = "",
    var restaurantAddress: String = "",
    var productCode: String = "",
    var restaurantImage: String = "",
    var restaurantId: Int = 0
) : Serializable
