package com.example.week3.ui.login

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.week2.di.Injection
import com.example.week3.R
import com.example.week3.model.login.LoginData
import com.example.week3.ui.select.SelectActivity
import com.example.week3.viewModel.StringViewModel
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.iid.FirebaseInstanceId
import kotlinx.android.synthetic.main.activity_login_account.*

class LoginActivity : AppCompatActivity(), View.OnClickListener{
    private lateinit var loginViewModel : StringViewModel
    private var logindata : LoginData = LoginData()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_account)

        loginViewModel =viewModel()
        bindViewModel()
    }

    override fun onClick(p0: View?) {
        if(p0!=null)
        {
            when(p0.id)
            {
                R.id.bt_login-> logIn()
            }
        }
    }
    fun logIn(){
        if(tv_login_email_emailname.text.isNullOrBlank() || tv_login_email_password.text.isNullOrBlank())
        {
            FirebaseInstanceId.getInstance().instanceId
                .addOnCompleteListener(OnCompleteListener { task ->
                    if (task.isSuccessful)
                    {
                        Log.w("failed", task.exception)
                        return@OnCompleteListener
                    }
                    val email : String = tv_login_email_emailname.text.toString()
                    val password :String = tv_login_email_password.text.toString()
                    val token: String = task.result?.token.toString()
                    loginViewModel.getLoginIf(email, password, token)
                })
        }
    }
    fun bindViewModel(){
        loginViewModel.loginIf.observe(this, {
            logindata.apply { logindata = it }
            val accessToken = logindata.SignInData?.accessToken
            saveAccessToken(accessToken)
            val intent = Intent(this@LoginActivity, SelectActivity::class.java)
            startActivity(intent)
        })
    }
    private fun saveAccessToken(token : String?){
        val sharedPreferences: SharedPreferences = getSharedPreferences("sharedPreferences", MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.clear()
        editor.putString("AccessToken", token).apply()
    }

    private fun viewModel(): StringViewModel {
        val viewModelFactory = Injection.provideViewModelFactory()
        return ViewModelProvider(this, viewModelFactory)[StringViewModel::class.java]
    }
}