package com.example.week3.ui.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.week3.R
import kotlinx.android.synthetic.main.activity_login.*


class RegisterActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        bt_sign_up_email.setOnClickListener(this)
        bt_login.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        if(p0 != null)
        {
            when(p0.id)
            {
                R.id.bt_sign_up_email ->
                {
                    val intent = Intent(this@RegisterActivity, RegisterEmailActivity::class.java)
                    startActivity(intent)
                }
                R.id.bt_login ->
                {
                    val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}