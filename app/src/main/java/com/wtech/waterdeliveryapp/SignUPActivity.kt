package com.wtech.waterdeliveryapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.view.isVisible
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class SignUPActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth;
    private lateinit var signUpButton: Button
    private lateinit var email:TextInputEditText
    private lateinit var firstName:TextInputEditText
    private lateinit var lastName:TextInputEditText
    private lateinit var password:TextInputEditText
    private lateinit var userName:TextInputEditText
    private lateinit var emailLayout:TextInputLayout
    private lateinit var usernameLayout: TextInputLayout
    private lateinit var lastNameLayout: TextInputLayout
    private lateinit var passwordLayout: TextInputLayout
    private lateinit var firstNameLayout:TextInputLayout
    private lateinit var  progressBar: ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_upactivity)
        progressBar=findViewById(R.id.progressBar)

        // Initialize Firebase Auth
        auth = Firebase.auth
        signUpButton=findViewById(R.id.signUpSignUp)
        email  =findViewById(R.id.email)
        lastName=findViewById(R.id.lastName)
        firstName=findViewById(R.id.firstNAme)
        userName=findViewById(R.id.userName)
        password=findViewById(R.id.userPassword)

        emailLayout=findViewById(R.id.emailLayout)
        lastNameLayout=findViewById(R.id.lastNameLayout)
        firstNameLayout=findViewById(R.id.firstNameLayout)
        passwordLayout=findViewById(R.id.passwordLayout)
        usernameLayout=findViewById(R.id.userNameLayout)
        signUpButton.setOnClickListener {
            val lName:String=lastName.text.toString().trim()
            val fName:String=firstName.text.toString().trim()
            val email:String=email.text.toString().trim()
            val userName:String=userName.text.toString().trim()
            val password:String=password.text.toString().trim()

           if (lName.isEmpty()){
               lastNameLayout.error="Please enter Name"
               lastNameLayout.requestFocus()
           }
            if (fName.isEmpty()){
                firstNameLayout.error="please Enter Name"
                firstNameLayout.requestFocus()
            }
            if (email.isEmpty()){
                emailLayout.error="Email Required"
                emailLayout.requestFocus()
            } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                emailLayout.error="Please Enter a valid Email"
                emailLayout.requestFocus()
            }
            if (userName.isEmpty()){
                usernameLayout.error="Enter a userName"
                usernameLayout.requestFocus()
            }
            if(password.isEmpty()){
                passwordLayout.error="Enter a valid password"
                passwordLayout.requestFocus()
            }
            progressBar.visibility=View.VISIBLE
            auth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener { task->
                    if (task.isSuccessful){
                        val user=User(fName,
                        lName,
                        email,
                        userName, password)

                        // Write a message to the database
                        val database = Firebase.database
                        val myRef = auth.currentUser?.let { it1 ->
                            database.getReference("Users")
                                .child(user.userName)
                                .setValue(user)
                                .addOnCompleteListener {
                                    if (it.isSuccessful){
                                        Toast.makeText(this@SignUPActivity,"$fName registered successfully",
                                            Toast.LENGTH_LONG)
                                            .show()
                                    } else{
                                        Toast.makeText(this@SignUPActivity,"$fName save Registration Failed",
                                            Toast.LENGTH_LONG)
                                            .show()
                                    }
                                }
                        }


                        Toast.makeText(this@SignUPActivity,"$fName registered successfully",
                            Toast.LENGTH_LONG)
                            .show()
                        progressBar.visibility=View.GONE
                        startActivity(Intent(this@SignUPActivity,WelcomeActivity::class.java))
                        finish()
                    } else{
                        Toast.makeText(this@SignUPActivity,"$fName con Registration Failed",
                            Toast.LENGTH_LONG)
                            .show()
                    }
                }


        }
    }
}