package com.example.week3.ui.login

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
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

        addEvent()
        bt_login_email.setOnClickListener(this)
        ib_login_back.setOnClickListener(this)
        loginViewModel = viewModel()
    }

    override fun onClick(view: View?) {
        if(view != null)
        {
            when(view.id)
            {
                R.id.ib_login_back->
                {
                    val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
                    startActivity(intent)
                }
                R.id.bt_login_email-> logIn()
            }
        }
    }

    private fun addEvent() {
        ed_login_email_password_edittext.transformationMethod = PasswordTransformationMethod.getInstance()
    }

    private fun logIn(){
        if(!ed_login_email_emailname_edittext.text.isNullOrBlank() || !ed_login_email_password_edittext.text.isNullOrBlank())
        {
            FirebaseInstanceId.getInstance().instanceId
                .addOnCompleteListener(OnCompleteListener { task ->
                    if (!task.isSuccessful)
                    {
                        Log.w("failed", task.exception)
                        return@OnCompleteListener
                    }
                    else{
                        val email : String = ed_login_email_emailname_edittext.text.toString()
                        val password :String = ed_login_email_password_edittext.text.toString()
                        val token: String = task.result?.token.toString()
                        loginViewModel.getLoginIf(email, password, token)
                        bindViewModel()
                    }

                })
        }
    }

    private fun bindViewModel(){
        loginViewModel.loginIf?.observe(this, {
            logindata.apply { logindata = it }
            val accessToken = logindata.SignInData?.accessToken
            saveAccessToken(accessToken)
            val intent = Intent(this@LoginActivity, SelectActivity::class.java)
            startActivity(intent)
        })

        loginViewModel.networkState.observe(this, Observer {
            Log.d("Lingard", it.toString())
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