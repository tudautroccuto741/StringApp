package com.example.week3.model.register


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("access_token")
    val accessToken: String,
    @SerializedName("badgeID")
    val badgeID: Int,
    @SerializedName("bio")
    val bio: String,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("currentLocation")
    val currentLocation: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("facebookID")
    val facebookID: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("isActive")
    val isActive: Boolean,
    @SerializedName("isSuperUser")
    val isSuperUser: Boolean,
    @SerializedName("notificationSettings")
    val notificationSettings: NotificationSettings,
    @SerializedName("profilePhoto")
    val profilePhoto: String,
    @SerializedName("refresh_token")
    val refreshToken: String,
    @SerializedName("trash")
    val trash: Boolean,
    @SerializedName("type")
    val type: String,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("username")
    val username: String,
    @SerializedName("wanderlust_details")
    val wanderlustDetails: WanderlustDetails,
    @SerializedName("website")
    val website: String
)