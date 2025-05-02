package com.doan.mechacal

import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class EditProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        val backingButton = findViewById<ImageView>(R.id.backing)
        backingButton.setOnClickListener {
            finish()
        }

        val confirmProfile : LinearLayout = findViewById(R.id.confirm_profile)
        confirmProfile.setOnClickListener{
            finish()
        }
    }
}