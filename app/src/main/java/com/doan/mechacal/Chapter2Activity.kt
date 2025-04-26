package com.doan.mechacal

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.sin

class Chapter2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chapter2)

        val backingButton = findViewById<ImageView>(R.id.backing)
        backingButton.setOnClickListener {
            finish()
        }

        // Lấy các input
        val PValue = findViewById<EditText>(R.id.PValue)
        val vValue = findViewById<EditText>(R.id.vValue)
        val z1Value = findViewById<EditText>(R.id.z1Value)
        val pValue = findViewById<EditText>(R.id.pValue)
        val z2Value = findViewById<EditText>(R.id.z2Value)

        val calculateButton = findViewById<LinearLayout>(R.id.calculate)
        calculateButton.setOnClickListener {

            // Đọc dữ liệu từ EditText
            val P = PValue.text.toString().toDoubleOrNull() ?: 0.0
            val v = vValue.text.toString().toDoubleOrNull() ?: 0.0
            val z1 = z1Value.text.toString().toIntOrNull() ?: 0
            val p = pValue.text.toString().toDoubleOrNull() ?: 0.0
            val z2 = z2Value.text.toString().toIntOrNull() ?: 0

            // Kiểm tra input
            if (P == 0.0 || v == 0.0 || z1 == 0 || p == 0.0 || z2 == 0) {
                Toast.makeText(this, "Vui lòng nhập đầy đủ dữ liệu!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Công thức tính bộ truyền xích
            val F = (P * 1000) / v // Lực vòng F (N)
            val n_x = (v * 60 * 1000) / (p * z1) // Số vòng quay đĩa xích nhỏ (vòng/phút)
            val d1 = p / sin(Math.toRadians(180.0 / z1)) // Đường kính vòng chia đĩa xích nhỏ (mm)
            val u_x = z2.toDouble() / z1 // Tỉ số truyền u_x

            // Truyền kết quả sang màn hình Chapter2resultActivity
            val intent = Intent(this, Chapter2resultActivity::class.java).apply {
                putExtra("F", F)
                putExtra("n_x", n_x)
                putExtra("d1", d1)
                putExtra("z1", z1)
                putExtra("z2", z2)
                putExtra("u_x", u_x)
            }

            startActivity(intent)
        }
    }
}
