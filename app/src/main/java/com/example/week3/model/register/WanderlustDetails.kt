package com.example.week3.model.register


import com.google.gson.annotations.SerializedName

data class WanderlustDetails(
    @SerializedName("isWanderlust")
    val isWanderlust: Boolean,
    @SerializedName("location")
    val location: Location
)