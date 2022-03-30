package com.pordo.adminnegocios.ui.register

import android.util.Patterns
import android.widget.Toast
import androidx.core.util.PatternsCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pordo.adminnegocios.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


import java.sql.Types

class RegisterViewModel : ViewModel() {

    private val userRepository = UserRepository()

    private val msg: MutableLiveData<String> = MutableLiveData()
    val msgDone: LiveData<String> = msg

    private val dataValidate: MutableLiveData<Boolean> = MutableLiveData()
    val dataValidated: LiveData<Boolean> = dataValidate


    fun validateFields(
        name: String,
        email: String,
        password: String,
        repPassword: String,
        cellphone: String
    ) {
        if (name.isEmpty() || email.isEmpty() || password.isEmpty() || repPassword.isEmpty() || cellphone.isEmpty()) {
            msg.value = "Debe digitar nombre, Email y contrasena"
        } else {
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                msg.value = "Debe digitar Email correctamente"
            } else {
                if (password.length < 6) {
                    msg.value = "Debe digitar contrasena de mas de 6 digitos"
                } else {
                    if (password.equals(repPassword)) {
                        dataValidate.value = true
                    } else {
                        msg.value = "Las contrasenas no son iguales"


                    }
                }


            }
        }
    }


    fun saveUsers(
        name: String,
        email: String,
        password: String,
        cellphone: String
    ) {
        GlobalScope.launch(Dispatchers.IO) {
            userRepository.saveUser(
                name,
                email,
                password,
                cellphone
            )
        }
    }
}