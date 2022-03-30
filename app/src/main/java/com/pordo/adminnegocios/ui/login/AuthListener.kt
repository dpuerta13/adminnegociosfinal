package com.pordo.adminnegocios.ui.login


interface AuthListener {
    fun onStarted()
    fun onSuccess()
    fun onFailure(message: String)
}