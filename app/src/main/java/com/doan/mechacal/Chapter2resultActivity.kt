package com.doan.mechacal

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Chapter2resultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chapter2result)

        val backingButton = findViewById<ImageView>(R.id.backing)
        backingButton.setOnClickListener {
            finish()
        }

        val save = findViewById<LinearLayout>(R.id.save_data)
        save.setOnClickListener{
            val intent = Intent(this,CreateSessionActivity::class.java)
            startActivity(intent)
        }

        // Nhận dữ liệu từ Intent
        val force = intent.getDoubleExtra("F", 0.0)
        val nx = intent.getDoubleExtra("n_x", 0.0)
        val d1 = intent.getDoubleExtra("d1", 0.0)
        val z1 = intent.getIntExtra("z1", 0)
        val z2 = intent.getIntExtra("z2", 0)
        val ux = intent.getDoubleExtra("u_x", 0.0)

        // Hiển thị kết quả
        val resultForce = findViewById<TextView>(R.id.resultForce)
        val resultNx = findViewById<TextView>(R.id.resultNx)
        val resultD1 = findViewById<TextView>(R.id.resultD1)
        val resultZ1 = findViewById<TextView>(R.id.resultZ1)
        val resultZ2 = findViewById<TextView>(R.id.resultZ2)
        val resultUx = findViewById<TextView>(R.id.resultUx)

        resultForce.text = "$force"
        resultNx.text = "$nx"
        resultD1.text = "$d1"
        resultZ1.text = "$z1 răng"
        resultZ2.text = "$z2 răng"
        resultUx.text = "$ux"
    }
}
