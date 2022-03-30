package com.pordo.adminnegocios.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pordo.adminnegocios.databinding.ActivitySplashBinding
import com.pordo.adminnegocios.ui.login.LoginActivity
import java.util.*
import kotlin.concurrent.timerTask
import java.util.Timer as Timer1


class SplashActivity : AppCompatActivity() {

    private lateinit var splashBinding: ActivitySplashBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashBinding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(splashBinding.root)

        val timer = Timer1()
        timer.schedule(
            timerTask {
                goToLoginActivity()
            },  2000
        )
    }

    private fun goToLoginActivity() {
        val intent = Intent(this, LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }
}
