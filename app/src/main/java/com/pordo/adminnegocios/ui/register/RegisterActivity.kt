package com.pordo.adminnegocios.ui.register

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.util.PatternsCompat
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import com.pordo.adminnegocios.databinding.ActivityRegisterBinding
import com.pordo.adminnegocios.ui.login.LoginActivity
import java.util.*


class RegisterActivity : AppCompatActivity() {

    private lateinit var registerViewModel: RegisterViewModel
    private lateinit var registerBinding: ActivityRegisterBinding
/*
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        registerBinding = ActivityRegisterBinding.inflate(inflater, container, false)
        registerViewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)
        return registerBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerBinding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(registerBinding.root)
        registerViewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)



    registerViewModel.msgDone.observe(this, { result ->
        toast(result)
    })

    registerViewModel.dataValidated.observe(this, { result ->
        onDataValidatedSubscribe(result)
    })



        with(registerBinding) {


            registerButton.setOnClickListener {
                registerViewModel.validateFields(
                    nameEditText.text.toString(),
                    emailEditText.text.toString(),
                    passwordEditText.text.toString(),
                    repPasswordEditText.text.toString(),
                    cellphoneEditText.text.toString()
                )
            }
        }
    }

/*
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerBinding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(registerBinding.root)

        with(registerBinding) {
            registerButton.setOnClickListener {
            }
                val name = nameEditText.text.toString()
                val email = emailEditText.text.toString()
                val password = passwordEditText.text.toString()
                val repPassword = repPasswordEditText.text.toString()
                val cellphone = cellphoneEditText.text.toString()

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



                                        registerViewModel.saveUser(name,email,password,cellphone)


                            }

                        }
                    }
                }*/

    private fun onDataValidatedSubscribe(result: Boolean?) {
        with(registerBinding) {
            val name = nameEditText.text.toString()
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()
            val cellphone = cellphoneEditText.text.toString()
            registerViewModel.saveUsers(name,cellphone,email)
            val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    private fun Context.toast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

}