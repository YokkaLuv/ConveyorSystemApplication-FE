package com.doan.mechacal

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.doan.mechacal.CreateSessionActivity
import com.doan.mechacal.UserFrontpage
import com.doan.mechacal.R

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_page)

        val btnSignup: LinearLayout = findViewById(R.id.sign_up)
        btnSignup.setOnClickListener {
            val intent = Intent(this, UserFrontpage::class.java)
            startActivity(intent)
        }
        val signin: TextView = findViewById(R.id.signin_link)
        signin.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
