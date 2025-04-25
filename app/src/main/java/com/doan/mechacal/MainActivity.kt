package com.doan.mechacal

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.doan.mechacal.CreateSessionActivity
import com.doan.mechacal.UserFrontpage
import com.doan.mechacal.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSignin: Button = findViewById(R.id.btn_signin)
        btnSignin.setOnClickListener {
            val intent = Intent(this, UserFrontpage::class.java)
            startActivity(intent)
        }
    }
}
