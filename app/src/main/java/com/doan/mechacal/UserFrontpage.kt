package com.doan.mechacal

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class UserFrontpage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_frontpage)

        val createButton = findViewById<LinearLayout>(R.id.createBtn)

        createButton.setOnClickListener {
            val intent = Intent(this, CreateSessionActivity::class.java)
            startActivity(intent)
        }
        //  navbar
        val home: ImageView = findViewById(R.id.create_session_frame)
        home.setOnClickListener {
            val intent = Intent(this, UserFrontpage::class.java)
            startActivity(intent)
        }

        val profile: ImageView = findViewById(R.id.user_profile_frame)
        profile.setOnClickListener {
            val intent = Intent(this, UserProfileActivity::class.java)
            startActivity(intent)
        }
    }
}