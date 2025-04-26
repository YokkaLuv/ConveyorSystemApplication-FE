package com.doan.mechacal

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class Chapter1resultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chapter1result)

        val backingButton = findViewById<ImageView>(R.id.backing)
        backingButton.setOnClickListener {
            finish()
        }
        val save = findViewById<LinearLayout>(R.id.save_data)
        save.setOnClickListener{
            val intent = Intent(this,CreateSessionActivity::class.java)
            startActivity(intent)
        }
    }
}