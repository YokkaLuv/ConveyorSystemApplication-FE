package com.doan.mechacal

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Chapter4resultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chapter4result)

        val back = findViewById<ImageView>(R.id.backing)
        back.setOnClickListener {
            finish()
        }
        val save = findViewById<LinearLayout>(R.id.save_data)
        save.setOnClickListener {
            val intent = Intent(this, CreateSessionActivity::class.java)
            startActivity(intent)
        }

        val Tn = intent.getDoubleExtra("Tn", 0.0);
        val dmin = intent.getDoubleExtra("dmin", 0.0);

        val result_Tn = findViewById<TextView>(R.id.result_Tn);
        val result_dmin = findViewById<TextView>(R.id.result_dmin);

        result_Tn.text = "$Tn"
        result_dmin.text = "$dmin"
    }
}
