package com.wtech.waterdeliveryapp

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
        // Write a message to the database
        val database = Firebase.database
        val myRef = database.getReference("message")

        myRef.setValue("Hello, john")

        signupButton=findViewById(R.id.btnSignUp)
        signInButton=findViewById(R.id.btnSignIn)



        signupButton.setOnClickListener {

        }
        signInButton.setOnClickListener {

        }
    }
}