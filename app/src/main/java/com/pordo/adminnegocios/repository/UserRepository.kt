package com.pordo.adminnegocios.repository

import com.pordo.adminnegocios.db.entities.User
import com.pordo.adminnegocios.db.adminnegocios
import com.pordo.adminnegocios.db.UserDao
import java.sql.Types.NULL

class UserRepository {
    suspend fun saveUser(
        name: String,
        email: String,
        password: String,
        cellphone: String,
    ) {
        val user = User(
            id = NULL,
            name = name,
            email = email,
            password = password,
            cellphone = cellphone,
        )

        val userDao: UserDao = adminnegocios.database.UserDao()
        userDao.saveUser(user)
    }

    suspend fun searchUser(email: String): User {
        val userDao: UserDao = adminnegocios.database.UserDao()
        val user = userDao.searchUser(email)
        return user

    }

    suspend fun verifyLoginUser(email:String,password:String): User {
        val userDao: UserDao = adminnegocios.database.UserDao()
        return userDao.verifyLoginUser(email = email,password = password )
    }

    suspend fun deleteUser(user: User) {
        val userDao: UserDao = adminnegocios.database.UserDao()
        userDao.deleteUser(user)
    }

    suspend fun loadUsers(): ArrayList<User> {
        val userDao: UserDao = adminnegocios.database.UserDao()
        val usersList: ArrayList<User> = userDao.loadUsers() as ArrayList<User>
        return usersList
    }

    suspend fun updateUser(user: User) {
        val userDao: UserDao = adminnegocios.database.UserDao()
        userDao.updateUser(user)

    }
}