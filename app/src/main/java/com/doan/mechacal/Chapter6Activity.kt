package com.doan.mechacal

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class Chapter6Activity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chapter6)

        val back = findViewById<ImageView>(R.id.backing)
        back.setOnClickListener{
            finish()
        }
        val cal = findViewById<LinearLayout>(R.id.calculate)
        cal.setOnClickListener{
            val intent = Intent(this,Chapter6resultActivity::class.java)
            startActivity(intent)
        }



    }

}