package com.example.sakshamapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sakshamapp.activities.DashboardActivity
import com.example.sakshamapp.api.ApiService
import com.example.sakshamapp.dataclasses.LoginRequest
import com.example.sakshamapp.dataclasses.LoginResponse
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@AndroidEntryPoint

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var apiService: ApiService
    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: TextView
    private lateinit var errorMessageTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        usernameEditText = findViewById(R.id.editText)
        passwordEditText = findViewById(R.id.editText2)
        loginButton = findViewById(R.id.tvLogin)
        errorMessageTextView = findViewById(R.id.tvError)

        loginButton.setOnClickListener { login() }

    }

    private fun login() {
        val username = usernameEditText.text.toString()
        val password = passwordEditText.text.toString()
        val request=LoginRequest(username,password)
        apiService.login(request).enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful) {
                    val keypass = response.body()?.keypass ?: return
                    val intent = Intent(this@MainActivity, DashboardActivity::class.java).apply {
                        putExtra("KEYPASS", keypass)
                    }
                    startActivity(intent)
                    finish()
                } else {
                    errorMessageTextView.text = "Login failed"
                    errorMessageTextView.visibility = View.VISIBLE
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                errorMessageTextView.text = "Network error"
                errorMessageTextView.visibility = View.VISIBLE
            }
        })
    }
}