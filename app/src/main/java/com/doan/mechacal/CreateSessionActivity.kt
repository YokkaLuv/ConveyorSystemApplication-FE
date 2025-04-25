package com.doan.mechacal
import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
class CreateSessionActivity :AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_session)
        val backingButton = findViewById<ImageView>(R.id.backinglogo)
        backingButton.setOnClickListener {
            finish()
        }

        val chap1 = findViewById<LinearLayout>(R.id.chapter1)
        chap1.setOnClickListener{
            val intent = Intent(this,Chapter1Activity::class.java)
            startActivity(intent)
        }

        val chap2 = findViewById<LinearLayout>(R.id.chapter2)

        chap2.setOnClickListener{
            val intent = Intent(this,Chapter2Activity::class.java)
            startActivity(intent)
        }
        val chap3 = findViewById<LinearLayout>(R.id.chapter3)
        chap3.setOnClickListener{
            val intent = Intent(this,Chapter3Activity::class.java)
            startActivity(intent)
        }

        val chap4 = findViewById<LinearLayout>(R.id.chapter4)
        chap4.setOnClickListener{
            val intent = Intent(this,Chapter4Activity::class.java)
            startActivity(intent)
        }

        val chap5 = findViewById<LinearLayout>(R.id.chapter5)
        chap5.setOnClickListener{
            val intent = Intent(this,Chapter5Activity::class.java)
            startActivity(intent)
        }

        val chap6 = findViewById<LinearLayout>(R.id.chapter6)
        chap6.setOnClickListener{
            val intent = Intent(this,Chapter6Activity::class.java)
            startActivity(intent)
        }

        val chap7 = findViewById<LinearLayout>(R.id.chapter7)
        chap7.setOnClickListener{
            val intent = Intent(this,Chapter7Activity::class.java)
            startActivity(intent)
        }
    }

}