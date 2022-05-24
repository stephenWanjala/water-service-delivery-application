package com.wtech.waterdeliveryapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class SignInActivity : AppCompatActivity() {
    private lateinit var forgotPasswordTxet: TextView
    private lateinit var dontHaveAccount: TextView
    private lateinit var signInButton: Button
    private lateinit var signInUserName: TextInputEditText
    private lateinit var signInPassword: TextInputEditText
    private lateinit var signInUserNameLayout: TextInputLayout
    private lateinit var signInPasswordLayout: TextInputLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        dontHaveAccount = findViewById(R.id.dontHaveAccount)
        forgotPasswordTxet = findViewById(R.id.forgotPassword)
        signInButton = findViewById(R.id.signInButton)
        signInUserName=findViewById(R.id.signInUserName)
        signInPassword = findViewById(R.id.signInUserPassword)
        signInPasswordLayout = findViewById(R.id.signInPasswordLayout)
        signInUserNameLayout = findViewById(R.id.userNameSignInLayout)


        dontHaveAccount.setOnClickListener {
            startActivity(Intent(this@SignInActivity, SignUPActivity::class.java))
            finish()
        }
        signInButton.setOnClickListener {
            try {
            val username: String = signInUserName.text.toString().trim()
            val password: String = signInPassword.text.toString().trim()
            if (username.isEmpty()) {
                signInUserNameLayout.error = "Email address required"
                signInUserNameLayout.requestFocus()
            }
            if (!android.util.Patterns.EMAIL_ADDRESS.matcher(username).matches()) {
                signInUserNameLayout.error = "Enter valid Email Address"
                signInUserNameLayout.requestFocus()
            }
            if (password.isEmpty()) {
                signInPasswordLayout.error = "password required"
                signInPasswordLayout.requestFocus()
            }
            } catch (e:Exception){
                Toast.makeText(this@SignInActivity,e.toString(), Toast.LENGTH_LONG)
            }
        }

        forgotPasswordTxet.setOnClickListener {

        }


    }
}