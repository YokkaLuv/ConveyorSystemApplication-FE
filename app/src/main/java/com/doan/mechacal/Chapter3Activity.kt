package com.doan.mechacal

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.sqrt

class Chapter3Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chapter3)

        val back = findViewById<ImageView>(R.id.backing)
        back.setOnClickListener {
            finish()
        }

        val cal = findViewById<LinearLayout>(R.id.calculate)
        val input_N = findViewById<EditText>(R.id.input_N)
        val input_Nx = findViewById<EditText>(R.id.input_Nx)
        val input_Ux = findViewById<EditText>(R.id.input_Ux)
        cal.setOnClickListener {
            try{
                //Lấy Input
                val n = input_N.text.toString().toDoubleOrNull() ?: throw IllegalArgumentException("Invalid input for N");
                val nx = input_Nx.text.toString().toDoubleOrNull() ?: throw IllegalArgumentException("Invalid input for Nx");
                val ux = input_Ux.text.toString().toDoubleOrNull() ?: throw IllegalArgumentException("Invalid input for Ux");

                if (n !in 960.0..2950.0){
                    throw IllegalArgumentException("n must be between 960 and 2950");
                }
                if (nx !in 15.0 .. 25.0){
                    throw IllegalArgumentException("Nx must be between 15 and 25");
                }
                if (ux !in 2.0 .. 4.0){
                    throw IllegalArgumentException("Ux must be between 2 and 4");
                }

                //Phần tính toán
                val u_t = n / (nx * ux);
                val u_1 = sqrt(u_t);
                val u_2 = u_t / u_1;

                //Làm tròn u_1, u_2 đến 2 chữ số thập phân để hiển thị đẹp.
                val rounded_u1 = String.format("%.2f",u_1).toDouble();
                val rounded_u2 = String.format("%.2f",u_2).toDouble();

                //Chuyển kết quả ra màn hình
                val intent = Intent(this, Chapter3resultActivity::class.java).apply{
                    putExtra("ut", u_t);
                    putExtra("u1", rounded_u1);
                    putExtra("u2", rounded_u2);
                }
                startActivity(intent)
            } catch (e: IllegalArgumentException){
                Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
            }

        }
    }

}
