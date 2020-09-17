package com.example.week3.model.register


import com.google.gson.annotations.SerializedName

data class RegisterEmail(
    @SerializedName("code")
    val code: Int,
    @SerializedName("data")
    val registerEmailData: Data,
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: Boolean
)