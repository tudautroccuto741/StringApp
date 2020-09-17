package com.example.week3.api

import com.example.week3.model.login.LoginData
import com.example.week3.model.register.RegisterEmail
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface Api {
    companion object{
        private var instance : Api? = null
        private var BASE_URL = "http://string-api.vinova.sg/api/"
    fun create() : Api
    {
        val logger = HttpLoggingInterceptor()
        logger.level = HttpLoggingInterceptor.Level.BASIC

        val client = okhttp3.OkHttpClient.Builder()
            .addInterceptor(logger)
            .build()
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Api::class.java)
    }

    fun getInstance() : Api{
        if(instance==null)
        {
            synchronized(ApiService::class.java){
                instance = create()
            }
        }
        return instance!!
    }
    }
    @FormUrlEncoded
    @POST("users-register-email")
    fun userRegisterEmail(
    @Field("username") username : String?,
    @Field("name") name :String?,
    @Field("date_of_birth") date_of_birth  :String?,
    @Field("email") email  :String?,
    @Field("password") password  :String?,
    @Field("confirm_password") confirm_password  :String?
    ):Call<RegisterEmail>

    @FormUrlEncoded
    @POST("users-login")
    fun userLogin(
        @Field("username") username: String?,
        @Field("password") password : String?,
        @Field("fcm_token") fcm_token : String?
    ):Call<LoginData>
}