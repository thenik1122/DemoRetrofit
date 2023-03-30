package com.example.sharedpreference.apiretrofit.model

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose
import java.io.Serializable


data class MainModel (
    @SerializedName("ResponseCode")
    @Expose
    var responseCode: String? = null,

    @SerializedName("ResponseMessage")
    @Expose
    var responseMessage: String? = null,

    @SerializedName("data")
    @Expose
    var dataModels: List<DataModel>? = null
):Serializable