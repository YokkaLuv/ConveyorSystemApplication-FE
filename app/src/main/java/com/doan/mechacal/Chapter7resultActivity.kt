package com.doan.mechacal

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Chapter7resultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chapter7result)

        // Lấy kết quả từ Intent
        val b = intent.getDoubleExtra("b", 0.0)
        val h = intent.getDoubleExtra("h", 0.0)
        val tau = intent.getDoubleExtra("tau", 0.0)
        val lKeyMin = intent.getDoubleExtra("l_key_min", 0.0)

        // Hiển thị kết quả
        val resultB = findViewById<TextView>(R.id.result_b)
        val resultH = findViewById<TextView>(R.id.result_h)
        val resultTau = findViewById<TextView>(R.id.result_t)
        val resultLKeyMin = findViewById<TextView>(R.id.result_l_min)

        resultB.text = String.format("%.2f", b)
        resultH.text = String.format("%.2f", h)
        resultTau.text = String.format("%.2f", tau)
        resultLKeyMin.text = String.format("%.2f", lKeyMin)

        // Xử lý nút quay lại
        val back = findViewById<ImageView>(R.id.backing)
        back.setOnClickListener {
            finish()
        }

        // Xử lý nút lưu và tiếp tục
        val save = findViewById<LinearLayout>(R.id.save_data)
        save.setOnClickListener {
            val intent = Intent(this, CreateSessionActivity::class.java).apply {
                putExtra("b", b)
                putExtra("h", h)
                putExtra("tau", tau)
                putExtra("l_key_min", lKeyMin)
            }
            startActivity(intent)
        }
    }
}
