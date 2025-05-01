package com.doan.mechacal

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class FinalOutputActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final_output)

        val backingButton = findViewById<ImageView>(R.id.backing)
        backingButton.setOnClickListener {
            finish()
        }

        //button 1
        val toggleButton1: TextView = findViewById(R.id.specs)
        val extraContent1: LinearLayout = findViewById(R.id.specs_table)
        var isExpanded1 = false

        toggleButton1.setOnClickListener {
            if (isExpanded1) {
                extraContent1.visibility = View.GONE
                toggleButton1.text = "View Specification"
                toggleButton1.setBackgroundResource(R.drawable.btn_show_more)
            } else {
                extraContent1.visibility = View.VISIBLE
                toggleButton1.text = "Hide Specification"
                toggleButton1.setBackgroundResource(R.drawable.btn_show_less)
            }
            isExpanded1 = !isExpanded1
        }

        //button 2
        val toggleButton2: TextView = findViewById(R.id.view3d)
        val extraContent2: LinearLayout = findViewById(R.id.view_3d_content)
        var isExpanded2 = false

        toggleButton2.setOnClickListener {
            if (isExpanded2) {
                extraContent2.visibility = View.GONE
                toggleButton2.text = "View 3D Model"
                toggleButton2.setBackgroundResource(R.drawable.btn_show_more)
            } else {
                extraContent2.visibility = View.VISIBLE
                toggleButton2.text = "Hide 3D Model"
                toggleButton2.setBackgroundResource(R.drawable.btn_show_less)
            }
            isExpanded2 = !isExpanded2
        }

        //button 3
        val toggleButton3: TextView = findViewById(R.id.view_suggested)
        val extraContent3: LinearLayout = findViewById(R.id.suggest)
        var isExpanded3 = false

        toggleButton3.setOnClickListener {
            if (isExpanded3) {
                extraContent3.visibility = View.GONE
                toggleButton3.text = "View suggested products"
                toggleButton3.setBackgroundResource(R.drawable.btn_show_more)
            } else {
                extraContent3.visibility = View.VISIBLE
                toggleButton3.text = "Hide suggested products"
                toggleButton3.setBackgroundResource(R.drawable.btn_show_less)
            }
            isExpanded3 = !isExpanded3
        }
    }
}