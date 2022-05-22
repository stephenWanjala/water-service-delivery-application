package com.wtech.waterdeliveryapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.TextView
import androidx.core.view.isVisible

class SplashActivity : AppCompatActivity() {
    private lateinit var welcomeText:TextView
    private  lateinit var textLogo:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        supportActionBar?.hide()
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)

        welcomeText=findViewById(R.id.welcomeText)
        textLogo=findViewById(R.id.myLogoText)
        findViewById<TextView>(R.id.welcomeText)

        welcomeText. animate().translationX(1000f).setDuration(1000).startDelay = 2500
        textLogo.isVisible=true

        val thread = Thread {
            try {
                Thread.sleep(4000)
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                startActivity(Intent(this@SplashActivity,WelcomeActivity::class.java))
                finish()
            }
        }
        thread.start()
    }
}