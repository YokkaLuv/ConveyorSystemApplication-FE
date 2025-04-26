package com.doan.mechacal

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Chapter1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chapter1)

        val backingButton = findViewById<ImageView>(R.id.backing)
        backingButton.setOnClickListener {
            finish()
        }

        val FValue = findViewById<EditText>(R.id.FValue)
        val vValue = findViewById<EditText>(R.id.vValue)
        val zValue = findViewById<EditText>(R.id.zValue)
        val pValue = findViewById<EditText>(R.id.pValue)
        val LValue = findViewById<EditText>(R.id.LValue)
        val t1Value = findViewById<EditText>(R.id.t1Value)
        val t2Value = findViewById<EditText>(R.id.t2Value)
        val T1Value = findViewById<EditText>(R.id.T1Value)
        val T2Value = findViewById<EditText>(R.id.T2Value)

        val cal = findViewById<LinearLayout>(R.id.calculate)
        cal.setOnClickListener {

            // Retrieving input values
            val F = FValue.text.toString().toDoubleOrNull() ?: 0.0
            val v = vValue.text.toString().toDoubleOrNull() ?: 0.0
            val z = zValue.text.toString().toIntOrNull() ?: 0
            val p = pValue.text.toString().toDoubleOrNull() ?: 0.0
            val L = LValue.text.toString().toDoubleOrNull() ?: 0.0

            // Assuming values for efficiency factors (η)
            val η = 0.722 // From the previous calculations

            if (F == 0.0 || v == 0.0 || z == 0 || p == 0.0) {
                Toast.makeText(this, "Please enter all required values.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Calculations
            val P_tđ = F * v / 1000 // Power required (kW)
            val P_ct = P_tđ / η // Calculated motor power (kW)
            val n_s_b = (60000 * v) / (z * p) // Motor speed (rpm)

            // Create Intent to pass results to Chapter1resultActivity
            val intent = Intent(this, Chapter1resultActivity::class.java).apply {
                putExtra("P_tđ", P_tđ)
                putExtra("P_ct", P_ct)
                putExtra("n_s_b", n_s_b)
            }

            startActivity(intent)
        }
    }
}
