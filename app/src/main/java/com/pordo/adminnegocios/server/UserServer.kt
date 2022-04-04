package com.pordo.adminnegocios.server
import java.io.Serializable

data class UserServer(
    var uid: String? = null,
    var name: String? = null,
    var cellphone: String? = null,
    var email: String? = null,
):Serializable