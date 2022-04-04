package com.pordo.adminnegocios.ui.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.auth.FirebaseAuth
import com.pordo.adminnegocios.databinding.ActivityLoginBinding
import com.pordo.adminnegocios.db.entities.User
import com.pordo.adminnegocios.ui.main.MainActivity
import com.pordo.adminnegocios.ui.register.RegisterActivity


class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var loginBinding: ActivityLoginBinding
    private lateinit var loginViewModel: AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(loginBinding.root)
        loginViewModel = ViewModelProvider(this).get(AuthViewModel::class.java)

        loginViewModel.usuariodone.observe(this) { result ->
            onFindUserDoneSubscribe(result)
        }
        loginViewModel.msgDone.observe(this) { result ->
            onMsgDoneSubscribe(result)
        }
        loginViewModel.dataValidated.observe(this) { result ->
            onDataValidatedSubscribe(result)
        }
        with(loginBinding) {
            signInButton.setOnClickListener {
                val email = emailEditText.text.toString()
                val password=passwordEditText.text.toString()
                loginViewModel.searchUserInFirebase(email,password)
                //loginViewModel.searhUser(email)
            }
        }
        loginBinding.registerTextView.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    private fun onDataValidatedSubscribe(result: Boolean?) {
        //val usuario= auth.currentUser?.email
        //val usuario = FirebaseAuth.getInstance().currentUser?.email
        //Toast.makeText(applicationContext,"usuario es :$usuario",Toast.LENGTH_SHORT).show()
        val intent = Intent(this@LoginActivity, MainActivity::class.java)
        startActivity(intent)


    }

    private fun onMsgDoneSubscribe(msg: String?) {
        Toast.makeText(
            applicationContext,
            msg,
            Toast.LENGTH_SHORT
        ).show()
    }
    private fun onFindUserDoneSubscribe(user: User?) {
        val email=loginBinding.emailEditText.text.toString()
        val password=loginBinding.passwordEditText.text.toString()
        if (user != null) {
        }
        else{
            loginViewModel.searchUserInFirebase(email,password)
        }
    }

}

