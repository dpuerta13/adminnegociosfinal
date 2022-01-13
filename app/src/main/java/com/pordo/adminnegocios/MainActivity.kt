package com.pordo.adminnegocios

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var emailReceived: String? = ""
        var passwordReceived: String? = ""
        var credentials :Bundle? = intent.extras

        Toast.makeText(this, credentials?.getString("email"),Toast.LENGTH_LONG).show()
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
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.Logout) {
            var emailReceived: String? = ""
            var passwordReceived: String? = ""
            var credentials = intent.extras
            emailReceived = credentials?.getString("email")
            passwordReceived = credentials?.getString("password")

            var intent = Intent(this, LoginActivity::class.java)
            intent.putExtra("email",emailReceived)
            intent.putExtra("password",passwordReceived)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }


    override fun onBackPressed() {
        super.onBackPressed()
        Toast.makeText(this, "Bye", Toast.LENGTH_SHORT).show()
    }


}