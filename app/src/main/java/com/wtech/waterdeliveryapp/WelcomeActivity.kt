package com.wtech.waterdeliveryapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class WelcomeActivity : AppCompatActivity() {
    private lateinit var signupButton: Button
    private lateinit var signInButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)


        signupButton=findViewById(R.id.btnSignUp)
        signInButton=findViewById(R.id.btnSignIn)



        signupButton.setOnClickListener {
            startActivity(Intent(this@WelcomeActivity,SignUPActivity::class.java))
        }
        signInButton.setOnClickListener {
            startActivity(Intent(this@WelcomeActivity,SignInActivity::class.java))

        }
    }
}