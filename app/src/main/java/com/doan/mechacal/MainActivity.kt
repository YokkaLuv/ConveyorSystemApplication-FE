package com.doan.mechacal

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.doan.mechacal.CreateSessionActivity
import com.doan.mechacal.UserFrontpage
import com.doan.mechacal.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSignin: TextView = findViewById(R.id.sign_in)
        btnSignin.setOnClickListener {
            val intent = Intent(this, UserFrontpage::class.java)
            startActivity(intent)
        }
        val signup: TextView = findViewById(R.id.signup_link)
        signup.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}
