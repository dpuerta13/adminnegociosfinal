package com.pordo.adminnegocios

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.Toast.*
import androidx.core.util.PatternsCompat
import com.pordo.adminnegocios.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var registerBinding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerBinding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(registerBinding.root)

        with(registerBinding) {
            registerButton.setOnClickListener {
                val email = emailEditText.text.toString()
                val password = passwordEditText.text.toString()
                val repPassword = repPasswordEditText.text.toString()

                fun validateEmail(): Boolean {
                    return PatternsCompat.EMAIL_ADDRESS.matcher(email).matches()
                }
                if (email.isEmpty() or password.isEmpty() or repPassword.isEmpty()) {
                    Toast.makeText(applicationContext, "Por favor llene todos los campos", Toast.LENGTH_SHORT).show()
                } else {
                    if (!validateEmail()) {
                        Toast.makeText(applicationContext, "El Correo ingresado no es válido", Toast.LENGTH_SHORT).show()
                    } else {
                        if (password.length < 6) {
                            Toast.makeText(applicationContext, "Las contraseñas debe tener mínimo 6 caracteres", Toast.LENGTH_SHORT).show()
                        } else {
                            if (password.equals(repPassword)) {
                                val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
                                intent.putExtra("email", email)
                                intent.putExtra("password", password)
                                startActivity(intent)
                            } else {
                                Toast.makeText(applicationContext, "Las contraseñas deben ser iguales", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                }
            }
        }
}
}