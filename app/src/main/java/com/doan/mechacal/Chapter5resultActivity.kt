package com.doan.mechacal

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Chapter5resultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chapter5result)

        // Lấy kết quả từ Intent
        val fBt = intent.getDoubleExtra("f_bt", 0.0)
        val pBt = intent.getDoubleExtra("p_bt", 0.0)
        val lH = intent.getDoubleExtra("l_h", 0.0)

        // Hiển thị kết quả
        val resultFBt = findViewById<TextView>(R.id.result_Fbt)
        val resultPBt = findViewById<TextView>(R.id.result_Pbt)
        val resultLH = findViewById<TextView>(R.id.result_Lh)

        resultFBt.text = fBt.toString()
        resultPBt.text = pBt.toString()
        resultLH.text = lH.toString()

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
                putExtra("p_bt", pBt) //
            }
            startActivity(intent)
        }
    }
}
