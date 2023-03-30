package com.example.sharedpreference.apiretrofit.model

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose
import java.io.Serializable


data class DataModel(
    @SerializedName("order_id")
    @Expose
    var orderId: Int? = null,

    @SerializedName("user_id")
    @Expose
    var userId: Int? = null,

    @SerializedName("restaurant_id")
    @Expose
    var restaurantId: Int? = null,

    @SerializedName("user_name")
    @Expose
    var userName: String? = null,

    @SerializedName("restaurant_name")
    @Expose
    var restaurantName: String? = null,

    @SerializedName("contact_no")
    @Expose
    var contactNo: String? = null,

    @SerializedName("address")
    @Expose
    var address: String? = null,

    @SerializedName("restaurant_address")
    @Expose
    var restaurantAddress: String? = null,

    @SerializedName("status")
    @Expose
    var status: String? = null,

    @SerializedName("product_code")
    @Expose
    var productCode: String? = null,

    @SerializedName("start_time")
    @Expose
    var startTime: String? = null,

    @SerializedName("end_time")
    @Expose
    var endTime: String? = null,

    @SerializedName("restaurant_image")
    @Expose
    var restaurantImage: String? = null,

    @SerializedName("latitude")
    @Expose
    var latitude: String? = null,

    @SerializedName("longitude")
    @Expose
    var longitude: String? = null,

    @SerializedName("food_detail")
    @Expose
    var foodDetailModel: List<FoodDetailModel>? = null
) : Serializable
