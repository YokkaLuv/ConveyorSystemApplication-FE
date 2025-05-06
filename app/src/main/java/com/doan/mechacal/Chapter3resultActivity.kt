package com.doan.mechacal

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Chapter3resultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chapter3result)

        val back = findViewById<ImageView>(R.id.backing)
        back.setOnClickListener {
            finish()
        }
        val save = findViewById<LinearLayout>(R.id.save_data)
        save.setOnClickListener {
            val intent = Intent(this, CreateSessionActivity::class.java)
            startActivity(intent)
        }
        val ut = intent.getDoubleExtra("ut", 0.0);
        val u1 = intent.getDoubleExtra("u1", 0.0);
        val u2 = intent.getDoubleExtra("u2", 0.0);

        val result_ut = findViewById<TextView>(R.id.resultUt);
        val result_u1 = findViewById<TextView>(R.id.resultU1);
        val result_u2 = findViewById<TextView>(R.id.resultU2);

        result_ut.text = "$ut"
        result_u1.text = "$u1"
        result_u2.text = "$u2"
    }
}
