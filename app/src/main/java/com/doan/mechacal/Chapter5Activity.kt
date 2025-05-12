package com.doan.mechacal

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Chapter5Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chapter5)

        // Khai báo các view
        val back = findViewById<ImageView>(R.id.backing)
        val cal = findViewById<LinearLayout>(R.id.calculate)
        val inputF = findViewById<EditText>(R.id.FValue)
        val inputV = findViewById<EditText>(R.id.vValue)
        val inputL = findViewById<EditText>(R.id.LValue)

        // Xử lý nút quay lại
        back.setOnClickListener {
            finish()
        }

        // Xử lý nút tính toán
        cal.setOnClickListener {
            try {
                // Lấy giá trị đầu vào
                val f = inputF.text.toString().toDoubleOrNull()
                    ?: throw IllegalArgumentException("Vui lòng nhập lực vòng (F)")
                val v = inputV.text.toString().toDoubleOrNull()
                    ?: throw IllegalArgumentException("Vui lòng nhập vận tốc xích (v)")
                val l = inputL.text.toString().toDoubleOrNull()
                    ?: throw IllegalArgumentException("Vui lòng nhập thời gian phục vụ (L)")

                // Tính toán thông số băng tải
                val (fBt, pBt, lH) = calculateConveyorParameters(f, v, l)

                // Chuyển kết quả sang Chapter5resultActivity
                val intent = Intent(this, Chapter5resultActivity::class.java).apply {
                    putExtra("f_bt", fBt)
                    putExtra("p_bt", pBt)
                    putExtra("l_h", lH)
                }
                startActivity(intent)
            } catch (e: IllegalArgumentException) {
                Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    /**
     * Tính toán thông số băng tải dựa trên đầu vào.
     * @param f Lực vòng trên xích tải (N), giới hạn: 20000..30000
     * @param v Vận tốc xích tải (m/s), giới hạn: 0.4..0.6
     * @param l Thời gian phục vụ (năm), giới hạn: 6..10
     * @return Triple chứa F_bt (N), P_bt (kW), L_h (giờ)
     */
    private fun calculateConveyorParameters(f: Double, v: Double, l: Double): Triple<Double, Double, Double> {
        // Kiểm tra giới hạn đầu vào
        if (f !in 20000.0..30000.0) {
            throw IllegalArgumentException("F phải trong khoảng 20000 đến 30000 N")
        }
        if (v !in 0.4..0.6) {
            throw IllegalArgumentException("v phải trong khoảng 0.4 đến 0.6 m/s")
        }
        if (l !in 6.0..10.0) {
            throw IllegalArgumentException("L phải trong khoảng 6 đến 10 năm")
        }

        // Tính toán
        val fBt = f // Tải trọng băng tải (N)
        val pBt = (fBt * v) / 1000 // Công suất băng tải (kW)
        val lH = l * 8760 // Tuổi thọ băng tải (giờ)

        // Làm tròn P_bt đến 2 chữ số thập phân
        val pBtRounded = String.format("%.2f", pBt).toDouble()

        return Triple(fBt, pBtRounded, lH)
    }
}
