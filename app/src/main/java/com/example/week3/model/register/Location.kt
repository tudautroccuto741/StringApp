package com.example.week3.model.register


import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("description")
    val description: String,
    @SerializedName("lat")
    val lat: Int,
    @SerializedName("long")
    val long: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("placeID")
    val placeID: String
)