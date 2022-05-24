package com.wtech.waterdeliveryapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth

class SignInActivity : AppCompatActivity() {
    private lateinit var forgotPasswordTxet: TextView
    private lateinit var dontHaveAccount: TextView
    private lateinit var signInButton: Button
    private lateinit var signInUserName: TextInputEditText
    private lateinit var signInPassword: TextInputEditText
    private lateinit var signInUserNameLayout: TextInputLayout
    private lateinit var signInPasswordLayout: TextInputLayout
    private lateinit var progressBarSignIn: ProgressBar
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        dontHaveAccount = findViewById(R.id.dontHaveAccount)
        forgotPasswordTxet = findViewById(R.id.forgotPassword)
        signInButton = findViewById(R.id.signInButton)
        progressBarSignIn = findViewById(R.id.progressBar2)
        signInUserName = findViewById(R.id.signInUserName)
        signInPassword = findViewById(R.id.signInUserPassword)
        signInPasswordLayout = findViewById(R.id.signInPasswordLayout)
        signInUserNameLayout = findViewById(R.id.userNameSignInLayout)
        auth = FirebaseAuth.getInstance()



        dontHaveAccount.setOnClickListener {
            startActivity(Intent(this@SignInActivity, SignUPActivity::class.java))
            finish()
        }
        var password: String? = null
        var username: String? = null
        signInButton.setOnClickListener {
            try {

                username = signInUserName.text.toString().trim()
                password = signInPassword.text.toString().trim()
                if (username!!.isEmpty()) {
                    signInUserNameLayout.error = "Email address required"
                    signInUserNameLayout.requestFocus()
                }
                if (!android.util.Patterns.EMAIL_ADDRESS.matcher(username).matches()) {
                    signInUserNameLayout.error = "Enter valid Email Address"
                    signInUserNameLayout.requestFocus()
                }
                if (password!!.isEmpty()) {
                    signInPasswordLayout.error = "password required"
                    signInPasswordLayout.requestFocus()
                }
            } catch (e: Exception) {

                Toast.makeText(this@SignInActivity, e.toString(), Toast.LENGTH_LONG)
                    .show()
                progressBarSignIn.visibility=View.GONE
            }

            try {

                progressBarSignIn.visibility = View.VISIBLE
                auth.signInWithEmailAndPassword(username!!, password!!)
                    .addOnCompleteListener { task ->
                        if (task.isComplete && task.isSuccessful) {
                            Toast.makeText(this@SignInActivity,
                                "user signed in successfully",
                                Toast.LENGTH_LONG)
                                .show()
                            progressBarSignIn.visibility=View.GONE
                        } else {
                            Toast.makeText(this@SignInActivity, "Failed to sign in", Toast.LENGTH_LONG)
                                .show()
                            progressBarSignIn.visibility=View.GONE
                            signInUserName.text?.clear()
                            signInPassword.text?.clear()
                        }
                    }
            }  catch (e:Exception){
                Toast.makeText(this@SignInActivity,"Error:${e.printStackTrace()}",Toast.LENGTH_LONG)
                    .show()
            }

        }

        forgotPasswordTxet.setOnClickListener {
            startActivity(Intent(this@SignInActivity,ForgotPasswordActivity::class.java))


        }


    }
}