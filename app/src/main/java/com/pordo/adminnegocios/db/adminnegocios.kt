package com.pordo.adminnegocios.db

import android.app.Application
import androidx.room.Room
import com.pordo.adminnegocios.db.AppDatabase

class adminnegocios : Application() {

    companion object {
        lateinit var database: AppDatabase
    }

    override fun onCreate() {
        super.onCreate()

        database = Room.databaseBuilder(
            this,
            AppDatabase::class.java,
            "user_db"
        ).build()
    }
}