package com.doan.mechacal

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Chapter7Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chapter7)

        // Khai báo các view
        val back = findViewById<ImageView>(R.id.backing)
        val cal = findViewById<LinearLayout>(R.id.calculate)
        val inputT = findViewById<EditText>(R.id.input_t)
        val inputD = findViewById<EditText>(R.id.input_d)
        val inputLKey = findViewById<EditText>(R.id.input_l_key)
        val inputSigmaKey = findViewById<EditText>(R.id.input_sigma_key)

        // Xử lý nút quay lại
        back.setOnClickListener {
            finish()
        }

        // Xử lý nút tính toán
        cal.setOnClickListener {
            try {
                // Lấy giá trị đầu vào và thay thế dấu phẩy bằng dấu chấm
                val tText = inputT.text.toString().replace(",", ".")
                val dText = inputD.text.toString().replace(",", ".")
                val lKeyText = inputLKey.text.toString().replace(",", ".")
                val sigmaKeyText = inputSigmaKey.text.toString().replace(",", ".")

                val t = tText.toDoubleOrNull()
                    ?: throw IllegalArgumentException("Vui lòng nhập mômen xoắn (T) hợp lệ")
                val d = dText.toDoubleOrNull()
                    ?: throw IllegalArgumentException("Vui lòng nhập đường kính trục (d) hợp lệ")
                val lKey = lKeyText.toDoubleOrNull()
                    ?: throw IllegalArgumentException("Vui lòng nhập chiều dài then (l_key) hợp lệ")
                val sigmaKey = sigmaKeyText.toDoubleOrNull()
                    ?: throw IllegalArgumentException("Vui lòng nhập ứng suất cắt cho phép ([σ_key]) hợp lệ")

                // Tính toán thông số then
                val (b, h, tau, lKeyMin) = calculateKeyParameters(t, d, lKey, sigmaKey)

                // Chuyển kết quả sang Chapter7resultActivity
                val intent = Intent(this, Chapter7resultActivity::class.java).apply {
                    putExtra("b", b)
                    putExtra("h", h)
                    putExtra("tau", tau)
                    putExtra("l_key_min", lKeyMin)
                }
                startActivity(intent)
            } catch (e: IllegalArgumentException) {
                Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    /**
     * Tính toán thông số then dựa trên đầu vào.
     * @param t Mômen xoắn (N.m), giới hạn: 5000..7000
     * @param d Đường kính trục (mm), giới hạn: 60..80
     * @param lKey Chiều dài then (mm), giới hạn: 50..100
     * @param sigmaKey Ứng suất cắt cho phép (MPa), giới hạn: 50..80
     * @return Quadruple chứa b (mm), h (mm), tau (MPa), l_key_min (mm)
     */
    private fun calculateKeyParameters(t: Double, d: Double, lKey: Double, sigmaKey: Double): Quadruple<Double, Double, Double, Double> {
        // Kiểm tra giới hạn đầu vào
        if (t !in 5000.0..7000.0) {
            throw IllegalArgumentException("T phải trong khoảng 5000 đến 7000 N.m")
        }
        if (d !in 60.0..80.0) {
            throw IllegalArgumentException("d phải trong khoảng 60 đến 80 mm")
        }
        if (lKey !in 50.0..100.0) {
            throw IllegalArgumentException("l_key phải trong khoảng 50 đến 100 mm")
        }
        if (sigmaKey !in 50.0..80.0) {
            throw IllegalArgumentException("[σ_key] phải trong khoảng 50 đến 80 MPa")
        }

        // Chọn chiều rộng (b) và chiều cao (h) then theo tiêu chuẩn
        val (b, h) = when {
            d <= 70.0 -> Pair(20.0, 12.0) // d <= 70: b = 20mm, h = 12mm
            d <= 85.0 -> Pair(22.0, 14.0) // d <= 85: b = 22mm, h = 14mm
            else -> throw IllegalArgumentException("Đường kính trục không phù hợp")
        }

        // Tính ứng suất cắt
        val tau = (2 * t * 1000) / (d * lKey * b) // MPa

        // Tính chiều dài then tối thiểu
        val lKeyMin = (2 * t * 1000) / (d * b * sigmaKey) // mm

        // Làm tròn kết quả đến 2 chữ số thập phân
        val bRounded = String.format("%.2f", b).toDouble()
        val hRounded = String.format("%.2f", h).toDouble()
        val tauRounded = String.format("%.2f", tau).toDouble()
        val lKeyMinRounded = String.format("%.2f", lKeyMin).toDouble()

        return Quadruple(bRounded, hRounded, tauRounded, lKeyMinRounded)
    }
}

/**
 * Data class để trả về 4 giá trị.
 */
data class Quadruple<A, B, C, D>(val first: A, val second: B, val third: C, val fourth: D)
