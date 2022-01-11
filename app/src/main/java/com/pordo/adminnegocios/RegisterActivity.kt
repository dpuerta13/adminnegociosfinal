package com.pordo.adminnegocios

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.pordo.adminnegocios.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var registerBinding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerBinding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_register)

        with(registerBinding) {
            RegisterButton.setOnClickListener {
                val email = emailEditText.text.toString()
                val password = passwordEditText.text.toString()
                val repPassword = repPasswordEditText.text.toString()

                if (password.equals(repPassword)){
                    val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
                    intent.putExtra("email",email)
                    intent.putExtra("password",password)
                    startActivity(intent)

                } else
                    Toast.makeText(applicationContext, "las contrasenas deben ser iguales", Toast.LENGTH_SHORT).show()

            }
        }

    }
}