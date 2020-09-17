package com.example.week3.model.login


import com.google.gson.annotations.SerializedName

data class LoginData(
    @SerializedName("code")
    val code: Int?= null,
    @SerializedName("data")
    val SignInData: Data?= null,
    @SerializedName("message")
    val message: String?= null,
    @SerializedName("status")
    val status: Boolean?= null
)