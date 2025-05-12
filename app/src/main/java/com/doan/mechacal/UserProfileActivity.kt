package com.doan.mechacal

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class UserProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)

        val logOut = findViewById<LinearLayout>(R.id.log_out)
        logOut.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val back = findViewById<ImageView>(R.id.backing)
        back.setOnClickListener {
            finish()
        }

        // Retrieve name from SharedPreferences
        val sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
        val namek = sharedPreferences.getString("user_name", "Unknown") ?: "Unknown"
        val account_name = findViewById<TextView>(R.id.account_name)
        account_name.text = namek

        val changeProfile = findViewById<LinearLayout>(R.id.change_profile)
        changeProfile.setOnClickListener {
            val intent = Intent(this, EditProfileActivity::class.java)
            startActivity(intent)
        }

        val changePass = findViewById<LinearLayout>(R.id.change_pass)
        changePass.setOnClickListener {
            val intent = Intent(this, ChangePasswordActivity::class.java)
            startActivity(intent)
        }

        // Navbar
        val home = findViewById<ImageView>(R.id.create_session_frame)
        home.setOnClickListener {
            val intent = Intent(this, UserFrontpage::class.java)
            startActivity(intent)
        }

        val profile = findViewById<ImageView>(R.id.user_profile_frame)
        profile.setOnClickListener {
            val intent = Intent(this, UserProfileActivity::class.java)
            startActivity(intent)
        }
    }
}