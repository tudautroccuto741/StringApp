package com.example.week3.data

import com.google.gson.annotations.SerializedName

class ApiResponse<T>(
    val code : Int?,
    val message : String?,
    val status : Boolean?,
    @SerializedName(value = "data",alternate = ["results"])
    val data : T?
)