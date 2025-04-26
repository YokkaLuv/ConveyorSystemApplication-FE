package com.doan.mechacal

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class Chapter1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chapter1)

        val backingButton = findViewById<ImageView>(R.id.backing)
        backingButton.setOnClickListener {
            finish()
        }

        val cal = findViewById<LinearLayout>(R.id.calculate)

        cal.setOnClickListener{
            val intent = Intent(this,Chapter1resultActivity::class.java)
            startActivity(intent)
        }
    }


}
