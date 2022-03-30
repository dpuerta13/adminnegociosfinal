package com.pordo.adminnegocios.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.pordo.adminnegocios.R
import com.pordo.adminnegocios.ui.login.LoginActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var emailReceived: String? = ""
        var passwordReceived: String? = ""

    }
    override fun onStart() {
        super.onStart()
    }
    override fun onResume() {
        super.onResume()
    }

    override fun onRestart() {
        super.onRestart()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.overflow_menu, menu)
        return true
    }



    override fun onBackPressed() {
        super.onBackPressed()
        Toast.makeText(this, "Bye", Toast.LENGTH_SHORT).show()
    }


}