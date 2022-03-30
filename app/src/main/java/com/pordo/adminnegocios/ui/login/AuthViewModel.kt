package com.pordo.adminnegocios.ui.login

import android.content.Intent
import android.view.View
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pordo.adminnegocios.db.UserDao
import com.pordo.adminnegocios.db.adminnegocios
import com.pordo.adminnegocios.db.entities.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import com.pordo.adminnegocios.repository.UserRepository



class AuthViewModel : ViewModel() {


    val userRepository = UserRepository()


    private val msg: MutableLiveData<String> = MutableLiveData()
    val msgDone: LiveData<String> = msg

    private val dataValidate: MutableLiveData<Boolean> = MutableLiveData()
    val dataValidated: LiveData<Boolean> = dataValidate

    private val msg1: MutableLiveData<String> = MutableLiveData()
    val msgDone1: LiveData<String> = msg1

    private val dataValidate1: MutableLiveData<Boolean> = MutableLiveData()
    val dataValidated1: LiveData<Boolean> = dataValidate1

    private val usuario: MutableLiveData<User?> = MutableLiveData()
    val usuariodone: LiveData<User?> = usuario


    fun validateFields(
        email: String,
        password: String,
        ) {
        if (email.isEmpty() || password.isEmpty()) {
            msg.value = "Debe digitar nombre, Email y contrasena"
        } else {
            GlobalScope.launch(Dispatchers.IO) {
                usuario.postValue(userRepository.searchUser(email))

        }
    }}

    fun verifyLoginUser(email: String, password: String, ) {
        GlobalScope.launch(Dispatchers.IO) {
            usuario.postValue(userRepository.searchUser(email))

        }

    }
}


