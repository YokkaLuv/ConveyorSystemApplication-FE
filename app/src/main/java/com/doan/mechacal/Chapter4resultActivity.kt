package com.doan.mechacal
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class Chapter4resultActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState:Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chapter4result)

        val back = findViewById<ImageView>(R.id.backing)
        back.setOnClickListener{
            finish()
        }
        val save = findViewById<LinearLayout>(R.id.save_data)
        save.setOnClickListener{
            val intent = Intent(this,CreateSessionActivity::class.java)
            startActivity(intent)
        }
    }
}