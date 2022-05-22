package com.wtech.waterdeliveryapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class WelcomeActivity : AppCompatActivity() {
    private lateinit var signupButton: Button
    private lateinit var signInButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)


        signupButton=findViewById(R.id.btnSignUp)
        signInButton=findViewById(R.id.btnSignIn)



        signupButton.setOnClickListener {

        }
        signInButton.setOnClickListener {

        }
    }
}