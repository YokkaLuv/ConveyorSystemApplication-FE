package com.doan.mechacal

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class UserProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_profile)

        val logOut = findViewById<LinearLayout>(R.id.log_out)

        logOut.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val back = findViewById<ImageView>(R.id.backing)
        back.setOnClickListener {
            finish()
        }

        val changePass : LinearLayout = findViewById(R.id.change_pass)
        changePass.setOnClickListener {
            val intent = Intent(this, ChangePasswordActivity::class.java)
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