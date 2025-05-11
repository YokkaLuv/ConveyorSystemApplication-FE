package com.doan.mechacal

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.doan.mechacal.api.ApiClient
import com.doan.mechacal.api.ApiService
import com.doan.mechacal.api.AuthResponse
import com.doan.mechacal.api.RegisterRequest
import com.doan.mechacal.api.TokenManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {

    private lateinit var nameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var rePasswordEditText: EditText
    private lateinit var signUpButton: LinearLayout
    private lateinit var signInLink: TextView
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_page)

        // Ánh xạ view
        nameEditText       = findViewById(R.id.account_name)
        emailEditText      = findViewById(R.id.username)
        passwordEditText   = findViewById(R.id.password)
        rePasswordEditText = findViewById(R.id.re_password)
        signUpButton       = findViewById(R.id.sign_up)
        signInLink         = findViewById(R.id.signin_link)
        progressBar        = findViewById(R.id.progress_bar)

        signUpButton.setOnClickListener {
            val name       = nameEditText.text.toString().trim()
            val email      = emailEditText.text.toString().trim()
            val password   = passwordEditText.text.toString().trim()
            val rePassword = rePasswordEditText.text.toString().trim()

            // Kiểm tra nhập liệu
            when {
                email.isEmpty() || password.isEmpty() || rePassword.isEmpty() -> {
                    Toast.makeText(this, "Điền đầy đủ thông tin!", Toast.LENGTH_SHORT).show()
                }
                password != rePassword -> {
                    Toast.makeText(this, "Mật khẩu không khớp!", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    registerUser(name, email, password)
                }
            }
        }

        signInLink.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    private fun registerUser(name: String, email: String, password: String) {
        progressBar.visibility = ProgressBar.VISIBLE

        val api = ApiClient.getClient(this).create(ApiService::class.java)
        val request = RegisterRequest(name, email, email, password)

        api.register(request).enqueue(object : Callback<AuthResponse> {
            override fun onResponse(call: Call<AuthResponse>, response: Response<AuthResponse>) {
                progressBar.visibility = ProgressBar.GONE

                if (response.isSuccessful) {
                    val body = response.body()
                    val accessToken  = body?.accessToken
                    val refreshToken = body?.refreshToken

                    if (accessToken != null && refreshToken != null) {
                        // Lưu token ngay sau khi đăng ký
                        TokenManager.saveTokens(this@RegisterActivity, accessToken, refreshToken)
                        Toast.makeText(this@RegisterActivity, "Đăng ký thành công! Chuyển đến trang chính.", Toast.LENGTH_SHORT).show()

                        startActivity(Intent(this@RegisterActivity, UserFrontpage::class.java))
                        finish()
                    } else {
                        // Nếu API chỉ trả message, không trả token
                        Toast.makeText(this@RegisterActivity, "Đăng ký thành công! Vui lòng đăng nhập lại.", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this@RegisterActivity, MainActivity::class.java))
                        finish()
                    }
                } else {
                    Toast.makeText(this@RegisterActivity, "Đăng ký thất bại: ${response.code()}", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<AuthResponse>, t: Throwable) {
                progressBar.visibility = ProgressBar.GONE
                Toast.makeText(this@RegisterActivity, "Lỗi kết nối: ${t.localizedMessage}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
