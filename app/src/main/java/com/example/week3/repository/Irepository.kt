package com.example.week3.repository

import com.example.week3.data.Result
import com.example.week3.model.login.LoginData

interface Irepository {
    fun getLoginIf(username : String, password : String, fcm : String): Result<LoginData>
}