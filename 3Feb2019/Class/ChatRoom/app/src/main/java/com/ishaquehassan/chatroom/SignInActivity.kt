package com.ishaquehassan.chatroom

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignInActivity : AppCompatActivity() {

    lateinit var auth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)


        auth = FirebaseAuth.getInstance()
        if(auth.currentUser != null){
            startActivity(Intent(this,ChatActivity::class.java))
            finish()
        }

        signInBtn.setOnClickListener {
            val emailText = emailEt.text.toString()
            val passText = passEt.text.toString()
            var isError = false

            emailEt.error = null
            passEt.error = null

            if(emailText.isEmpty()){
                emailEt.error = "Please enter email"
                isError = true
            }

            if(passText.isEmpty()){
                passEt.error = "Please enter email"
                isError = true
            }

            if(!isError){
                signIn(emailText,passText)
            }
        }

        signUpTv.setOnClickListener {
            startActivity(Intent(this,SignUpActivity::class.java))
        }
    }

    private fun signIn(email:String,password:String){
        showProgress()
        auth.signInWithEmailAndPassword(email,password)
            .addOnCompleteListener {
                hideProgress()
                if(it.isSuccessful){
                    toast("Signed in!")
                    startActivity(Intent(this,ChatActivity::class.java))
                    finish()
                }else{
                    toast("Error : ${it.exception?.message}")
                }
            }

    }

    private fun showProgress(){
        progressView.show()
        signInBtn.hide()
    }

    private fun hideProgress(){
        progressView.hide()
        signInBtn.show()
    }
}
