package com.doan.mechacal

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.doan.mechacal.api.ApiClient
import com.doan.mechacal.api.ApiService
import com.doan.mechacal.api.AuthResponse
import com.doan.mechacal.api.LoginRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.doan.mechacal.api.TokenManager  // Import TokenManager

class MainActivity : AppCompatActivity() {

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var signInButton: LinearLayout
    private lateinit var signUpLink: TextView
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Ánh xạ các thành phần từ layout XML
        emailEditText = findViewById(R.id.username)
        passwordEditText = findViewById(R.id.password)
        signInButton = findViewById(R.id.sign_in)
        signUpLink = findViewById(R.id.signup_link)
        progressBar = findViewById(R.id.progress_bar)

        signInButton.setOnClickListener {
            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập đầy đủ email và mật khẩu", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            loginUser(email, password)
        }

        signUpLink.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    private fun loginUser(email: String, password: String) {
        progressBar.visibility = ProgressBar.VISIBLE

        val api = ApiClient.getClient(this).create(ApiService::class.java)
        val request = LoginRequest(email, password)

        api.login(request).enqueue(object : Callback<AuthResponse> {
            override fun onResponse(call: Call<AuthResponse>, response: Response<AuthResponse>) {
                progressBar.visibility = ProgressBar.GONE

                if (response.isSuccessful) {
                    val accessToken = response.body()?.accessToken
                    val refreshToken = response.body()?.refreshToken

                    if (accessToken != null && refreshToken != null) {
                        // Lưu token vào TokenManager
                        TokenManager.saveTokens(this@MainActivity, accessToken, refreshToken)

                        Toast.makeText(this@MainActivity, "Đăng nhập thành công!", Toast.LENGTH_SHORT).show()

                        // Chuyển sang giao diện chính
                        startActivity(Intent(this@MainActivity, UserFrontpage::class.java))
                        finish()
                    } else {
                        Toast.makeText(this@MainActivity, "Lỗi kết nối", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this@MainActivity, "Sai email hoặc mật khẩu", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<AuthResponse>, t: Throwable) {
                progressBar.visibility = ProgressBar.GONE
                Toast.makeText(this@MainActivity, "Lỗi kết nối: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
