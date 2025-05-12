package com.doan.mechacal

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Chapter6resultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chapter6result)

        // Lấy kết quả từ Intent
        val t = intent.getDoubleExtra("t", 0.0)
        val d = intent.getDoubleExtra("d", 0.0)
        val sigma = intent.getDoubleExtra("sigma", 0.0)

        // Hiển thị kết quả
        val resultT = findViewById<TextView>(R.id.result_t)
        val resultD = findViewById<TextView>(R.id.result_d)
        val resultSigma = findViewById<TextView>(R.id.result_sigma)

        resultT.text = String.format("%.2f", t)
        resultD.text = String.format("%.2f", d)
        resultSigma.text = String.format("%.2f", sigma)

        // Xử lý nút quay lại
        val back = findViewById<ImageView>(R.id.backing)
        back.setOnClickListener {
            finish()
        }

        // Xử lý nút lưu và tiếp tục
        val save = findViewById<LinearLayout>(R.id.save_data)
        save.setOnClickListener {
            // TODO: Lưu kết quả (ví dụ: vào SharedPreferences hoặc database)
            val intent = Intent(this, CreateSessionActivity::class.java).apply {
                putExtra("t", t) // Truyền T cho các chương tiếp theo (ví dụ: Chương 7)
                putExtra("d", d) // Truyền d cho các chương tiếp theo
            }
            startActivity(intent)
        }
    }
}
