package com.pordo.adminnegocios.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Types.NULL
import java.io.Serializable

const val CURRENT_USER_ID = 0

@Entity(tableName= "table_users")
data class User (
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") var id: Int = NULL,
    @ColumnInfo(name = "name") var name: String = "",
    @ColumnInfo(name = "email") var email: String = "",
    @ColumnInfo(name ="password") var password: String = "",
    @ColumnInfo(name = "cellphone") var cellphone: String= "",
        ) : Serializable
{

}
