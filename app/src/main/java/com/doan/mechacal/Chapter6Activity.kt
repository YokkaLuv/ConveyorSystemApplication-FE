package com.doan.mechacal

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.PI
import kotlin.math.cbrt

class Chapter6Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chapter6)

        // Khai báo các view
        val back = findViewById<ImageView>(R.id.backing)
        val cal = findViewById<LinearLayout>(R.id.calculate)
        val inputPBt = findViewById<EditText>(R.id.input_p_bt)
        val inputNx = findViewById<EditText>(R.id.input_nx)
        val inputSigma = findViewById<EditText>(R.id.input_sigma)

        // Xử lý nút quay lại
        back.setOnClickListener {
            finish()
        }

        // Xử lý nút tính toán
        cal.setOnClickListener {
            try {
                // Lấy giá trị đầu vào và thay thế dấu phẩy bằng dấu chấm
                val pBtText = inputPBt.text.toString().replace(",", ".")
                val nxText = inputNx.text.toString().replace(",", ".")
                val sigmaText = inputSigma.text.toString().replace(",", ".")

                val pBt = pBtText.toDoubleOrNull()
                    ?: throw IllegalArgumentException("Vui lòng nhập công suất băng tải (P_bt) hợp lệ")
                val nx = nxText.toDoubleOrNull()
                    ?: throw IllegalArgumentException("Vui lòng nhập số vòng quay đĩa xích (n_x) hợp lệ")
                val sigma = sigmaText.toDoubleOrNull()
                    ?: throw IllegalArgumentException("Vui lòng nhập ứng suất cho phép ([σ]) hợp lệ")

                // Tính toán thông số trục
                val (t, d, sigmaActual) = calculateShaftParameters(pBt, nx, sigma)

                // Chuyển kết quả sang Chapter6resultActivity
                val intent = Intent(this, Chapter6resultActivity::class.java).apply {
                    putExtra("t", t)
                    putExtra("d", d)
                    putExtra("sigma", sigmaActual)
                }
                startActivity(intent)
            } catch (e: IllegalArgumentException) {
                Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    /**
     * Tính toán thông số trục công tác dựa trên đầu vào.
     * @param pBt Công suất băng tải (kW), giới hạn: 10..15
     * @param nx Số vòng quay đĩa xích (vòng/phút), giới hạn: 15..25
     * @param sigma Ứng suất cho phép (MPa), giới hạn: 40..60
     * @return Triple chứa T (N.m), d (mm), sigma thực tế (MPa)
     */
    private fun calculateShaftParameters(pBt: Double, nx: Double, sigma: Double): Triple<Double, Double, Double> {
        // Kiểm tra giới hạn đầu vào
        if (pBt !in 10.0..15.0) {
            throw IllegalArgumentException("P_bt phải trong khoảng 10 đến 15 kW")
        }
        if (nx !in 15.0..25.0) {
            throw IllegalArgumentException("n_x phải trong khoảng 15 đến 25 vòng/phút")
        }
        if (sigma !in 40.0..60.0) {
            throw IllegalArgumentException("[σ] phải trong khoảng 40 đến 60 MPa")
        }

        // Tính toán
        val t = (pBt * 9550) / nx // Mômen xoắn (N.m)
        val d = cbrt((16 * t * 1000) / (PI * sigma)) // Đường kính trục (mm)
        val sigmaActual = (16 * t * 1000) / (PI * d * d * d) // Ứng suất thực tế (MPa)

        // Làm tròn kết quả đến 2 chữ số thập phân
        val tRounded = String.format("%.2f", t).toDouble()
        val dRounded = String.format("%.2f", d).toDouble()
        val sigmaRounded = String.format("%.2f", sigmaActual).toDouble()

        return Triple(tRounded, dRounded, sigmaRounded)
    }
}
