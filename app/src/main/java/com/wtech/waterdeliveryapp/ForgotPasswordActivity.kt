package com.wtech.waterdeliveryapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth

class ForgotPasswordActivity : AppCompatActivity() {
    private lateinit var  forgotPasswordEmailLayout: TextInputLayout
    private  lateinit var  forgotPasswordEditText:EditText
    private lateinit var forgotEmailEditText:EditText
    private lateinit var buttonResetPassword:Button
    private lateinit var forgotPasswordProgressBar: ProgressBar
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)
        auth=FirebaseAuth.getInstance()
        forgotEmailEditText=findViewById(R.id.forgotEmailEditText)
        forgotPasswordEmailLayout=findViewById(R.id.forgotPasswordEmailLayout)
        forgotPasswordProgressBar=findViewById(R.id.forgotPasswordProgressBar)
        buttonResetPassword=findViewById(R.id.buttonResetPassword)

        buttonResetPassword.setOnClickListener {
            resetPassword()

        }
    }

    private fun resetPassword() {
       val textEmail:String=forgotEmailEditText.text.toString().trim()
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(textEmail).matches()){
            forgotPasswordEmailLayout.error="Enter valid Email Address"
            forgotPasswordEmailLayout.requestFocus()
            return

        }

        forgotPasswordProgressBar.visibility=View.VISIBLE
        auth.sendPasswordResetEmail(textEmail)
            .addOnCompleteListener {  task->
                if (task.isSuccessful && task.isComplete){
                    Toast.makeText(this@ForgotPasswordActivity,"Email reset password sent",Toast.LENGTH_LONG)
                        .show()
                    startActivity(Intent(this@ForgotPasswordActivity,SignInActivity::class.java))
                    finish()
                }
                else{
                    Toast.makeText(this@ForgotPasswordActivity,"Failed to reset passwordTry again",Toast.LENGTH_LONG)
                        .show()
                    forgotPasswordProgressBar.visibility=View.GONE
                    startActivity(Intent(this@ForgotPasswordActivity,SignInActivity::class.java))
                        finish()
                }
            }

    }
}