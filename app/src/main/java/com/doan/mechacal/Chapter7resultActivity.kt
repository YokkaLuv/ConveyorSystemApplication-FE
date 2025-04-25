package com.doan.mechacal
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class Chapter7resultActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState:Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chapter7result)

        val back = findViewById<ImageView>(R.id.backing)
        back.setOnClickListener{
            finish()
        }

    }
}