package com.pordo.adminnegocios.ui.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.pordo.adminnegocios.databinding.ActivityLoginBinding
import com.pordo.adminnegocios.db.entities.User
import com.pordo.adminnegocios.ui.main.MainActivity
import com.pordo.adminnegocios.ui.register.RegisterActivity


class LoginActivity : AppCompatActivity() {

    private lateinit var loginBinding: ActivityLoginBinding
    private lateinit var loginViewModel: AuthViewModel
    private lateinit var usuario: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(loginBinding.root)
        loginViewModel = ViewModelProvider(this).get(AuthViewModel::class.java)


        loginBinding.registerTextView.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }


        loginViewModel.msgDone.observe(this, { result ->
            toast(result)
        })

//        loginViewModel.dataValidated.observe(this, { result ->
        //          onDataValidatedSubscribe(result)
        //      })

        loginViewModel.usuariodone.observe(this, { result ->
            onDataValidatedSubscribe(result)
        })


        with(loginBinding) {
            signInButton.setOnClickListener {
                val email = emailEditText.text.toString()
                val password = passwordEditText.text.toString()

                loginViewModel.validateFields(email, password)


/*
                if (email == emailReceived && password==passwordReceived && email.isNotEmpty() && password.isNotEmpty()){
                    val intent = Intent(this@LoginActivity, MainActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)

                } else{
                    Toast.makeText(this@LoginActivity,"Usuario o contrasena inconrrectos",Toast.LENGTH_SHORT).show()
                }
            }*/

            }

        }
    }

    private fun onDataValidatedSubscribe(usuario: User?) {
        if (usuario != null) {
            with(loginBinding) {
                val email = emailEditText.text.toString()
                val password = passwordEditText.text.toString()
                if (email == usuario.email) {
                    val intent = Intent(this@LoginActivity, MainActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(
                        this@LoginActivity,
                        "Usuario o contrasena inconrrectos",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
            else{
                Toast.makeText(
                    this@LoginActivity,
                    "Usuario o contrasena inconrrectos",
                    Toast.LENGTH_SHORT
                ).show()
            }

        }


    private fun Context.toast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

}

