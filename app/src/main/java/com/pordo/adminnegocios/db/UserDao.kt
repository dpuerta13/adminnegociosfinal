package com.pordo.adminnegocios.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.pordo.adminnegocios.db.entities.User

@Dao
interface UserDao {

    @Insert
    suspend fun saveUser(user: User)

    @Query("SELECT * FROM table_users WHERE email LIKE :email")
    suspend fun searchUser(email: String): User

    @Query("SELECT * FROM table_users WHERE email LIKE :email AND password LIKE :password")
    suspend fun verifyLoginUser(email: String, password: String): User

    @Delete
    suspend fun deleteUser(book: User)

    @Query("SELECT * FROM table_users")
    suspend fun loadUsers(): MutableList<User>

    @Update
    suspend fun updateUser(book: User)
}


