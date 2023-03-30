package com.example.sharedpreference.apiretrofit.model

import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose
import java.io.Serializable


data class FoodDetailModel (

    @SerializedName("food_id")
    @Expose
    var foodId: Int? = null,

    @SerializedName("food_name")
    @Expose
    var foodName: String? = null,

    @SerializedName("description")
    @Expose
    var description: String? = null,

    @SerializedName("quantity")
    @Expose
    var quantity: Int? = null,

    @SerializedName("original_price")
    @Expose
    var originalPrice: Int? = null,

    @SerializedName("total_price")
    @Expose
    var totalPrice: Int? = null,

    @SerializedName("food_image")
    @Expose
    var foodImage: String? = null
):Serializable