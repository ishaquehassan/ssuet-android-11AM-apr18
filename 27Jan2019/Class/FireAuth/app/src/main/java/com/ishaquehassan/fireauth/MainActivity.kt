package com.ishaquehassan.fireauth

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var auth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = FirebaseAuth.getInstance()

        auth.signOut()

        if(auth.currentUser != null){
            startActivity(Intent(this,HomeActivity::class.java))
            finish()
        }

        signUpBtn.setOnClickListener {
            val emailStr = emailEt.text.toString()
            val passwordStr = passwordEt.text.toString()
            val isOk = (!emailStr.isEmpty() && !passwordStr.isEmpty() && passwordStr.length >= 6)
            emailEt.error = null
            passwordEt.error = null

            if(emailStr.isEmpty()){
                emailEt.error = "Please enter email!"
            }
            if(passwordStr.isEmpty()){
                passwordEt.error = "Please enter Password!"
            }
            if(passwordStr.length < 6){
                passwordEt.error = "Password Must be at least 6 characters!"
            }
            if(isOk){
                signUp(emailStr,passwordStr)
            }
        }

    }

    private fun signUp(email:String,password:String){
        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener {
            if(it.isSuccessful){
                Toast.makeText(this,"Signed UP!",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this,"Error! : ${it.exception?.message}",Toast.LENGTH_SHORT).show()
            }
        }
    }
}
