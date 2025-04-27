package com.doan.mechacal

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class UserFrontpage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_frontpage)

        val createButton = findViewById<LinearLayout>(R.id.createBtn)

        createButton.setOnClickListener {
            val intent = Intent(this, CreateSessionActivity::class.java)
            startActivity(intent)
        }

    }

}