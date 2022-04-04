package com.pordo.adminnegocios.ui.login

import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.core.util.PatternsCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.pordo.adminnegocios.db.UserDao
import com.pordo.adminnegocios.db.adminnegocios
import com.pordo.adminnegocios.db.entities.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import com.pordo.adminnegocios.repository.UserRepository



class AuthViewModel : ViewModel() {
    private lateinit var auth: FirebaseAuth

    val userRepository = UserRepository()

    private val dataValidate: MutableLiveData<Boolean> = MutableLiveData()
    val dataValidated: LiveData<Boolean> = dataValidate

    private var campsValidate: Boolean = false


    private val msg: MutableLiveData<String> = MutableLiveData()
    val msgDone: LiveData<String> = msg

    private val msg1: MutableLiveData<String> = MutableLiveData()
    val msgDone1: LiveData<String> = msg1

    private val dataValidate1: MutableLiveData<Boolean> = MutableLiveData()
    val dataValidated1: LiveData<Boolean> = dataValidate1

    private val usuario: MutableLiveData<User?> = MutableLiveData()
    val usuariodone: LiveData<User?> = usuario

    private fun validarCorreo(email_: String): Boolean {
        return PatternsCompat.EMAIL_ADDRESS.matcher(email_).matches()
    }
    fun validateFields(email: String, password: String, ) {
        val valido = validarCorreo(email)
        if (email.isNotEmpty() && password.isNotEmpty()
        ) {
            if (valido) {
                campsValidate = true

            } else {
                msg.value = "Usuario ó Contraseña Incorrectos"
            }
        } else {
                msg.value = "Por Favor Llene Todos Los Campos"
        }

    }

    fun verifyLoginUser(email: String, password: String, ) {
        GlobalScope.launch(Dispatchers.IO) {
            usuario.postValue(userRepository.searchUser(email))
        }
        }

    fun searchUserInFirebase(email: String, password: String) {
            validateFields(email, password)

            if (campsValidate) {
                auth = Firebase.auth
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener() { task ->
                        if (task.isSuccessful) {
                            dataValidate.value = true

                        } else {
                            msg.value = "Usuario ó Contraseña Incorrectos"
                        }
                    }
            }
    }
}


