package com.doan.mechacal

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
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
        save.setOnClickListener {
            val intent = Intent(this, CreateSessionActivity::class.java)
            startActivity(intent)
        }

        // Retrieve data from Intent
        val P_tđ = intent.getDoubleExtra("P_tđ", 0.0)
        val P_ct = intent.getDoubleExtra("P_ct", 0.0)
        val n_s_b = intent.getDoubleExtra("n_s_b", 0.0)

        // Display the results
        val resultP_tđ = findViewById<TextView>(R.id.resultP_tđ)
        val resultP_ct = findViewById<TextView>(R.id.resultP_ct)
        val resultN_s_b = findViewById<TextView>(R.id.resultN_s_b)

        resultP_tđ.text = "$P_tđ"
        resultP_ct.text = "$P_ct"
        resultN_s_b.text = "$n_s_b"
    }
}
