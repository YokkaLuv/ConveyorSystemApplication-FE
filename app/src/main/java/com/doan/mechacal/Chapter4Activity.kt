package com.doan.mechacal

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.*
class Chapter4Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chapter4)

        val back = findViewById<ImageView>(R.id.backing)
        back.setOnClickListener {
            finish()
        }

        val cal = findViewById<LinearLayout>(R.id.calculate)
        cal.setOnClickListener {
            val intent = Intent(this, Chapter4resultActivity::class.java)
            startActivity(intent)
        }
        val TValue = findViewById<EditText>(R.id.TValue)
        val nValue = findViewById<EditText>(R.id.nValue)
        val tValue = findViewById<EditText>(R.id.tValue)
        val ksValue = findViewById<EditText>(R.id.ksValue)
        val dValue = findViewById<EditText>(R.id.dValue)

        cal.setOnClickListener {

            // Retrieving input values
            val T = TValue.text.toString().toDoubleOrNull() ?: 0.0
            val n = nValue.text.toString().toDoubleOrNull() ?: 0.0
            val t = tValue.text.toString().toIntOrNull() ?: 0
            val ks = ksValue.text.toString().toDoubleOrNull() ?: 0.0
            val d = dValue.text.toString().toDoubleOrNull() ?: 0.0

            // Assuming values for efficiency factors (η)


            if (T == 0.0 || n == 0.0 || t == 0 || ks == 0.0 || d == 0.0) {
                Toast.makeText(this, "Please enter all required values.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Calculations
            val Tn = T * ks  // Momen xoắn danh định của khớp nối (Nm)
            val dmin = cbrt((16 * T * 1000)/PI * t);

            // Create Intent to pass results to Chapter1resultActivity
            val intent = Intent(this, Chapter1resultActivity::class.java).apply {
                putExtra("Tn", Tn)
                putExtra("dmin", dmin)
            }

            startActivity(intent)
        }
    }

}
