package com.pordo.adminnegocios.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.pordo.adminnegocios.db.entities.User


@Database(
    entities = [User::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun UserDao() : UserDao


}


