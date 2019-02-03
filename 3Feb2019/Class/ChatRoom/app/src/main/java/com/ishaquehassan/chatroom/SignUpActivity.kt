package com.ishaquehassan.chatroom

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    lateinit var auth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        auth = FirebaseAuth.getInstance()
        signUpBtn.setOnClickListener {
            val emailText = emailEt.text.toString()
            val passText = passEt.text.toString()
            val fullNameText = fullNameEt.text.toString()
            val ageText = ageEt.text.toString()

            var isError = false

            emailEt.error = null
            passEt.error = null
            fullNameEt.error = null
            ageEt.error = null

            if(emailText.isEmpty()){
                emailEt.error = "Please enter email"
                isError = true
            }

            if(passText.isEmpty()){
                passEt.error = "Please enter email"
                isError = true
            }

            if(fullNameText.isEmpty()){
                fullNameEt.error = "Please enter Full Name"
                isError = true
            }

            if(ageText.isEmpty()){
                ageEt.error = "Please enter Your Age"
                isError = true
            }

            if(!isError){
                signIn(emailText,passText,fullNameText,ageText)
            }
        }

        signInTv.setOnClickListener {
            finish()
        }
    }

    private fun signIn(email:String,password:String,fullName:String,age:String){
        showProgress()
        auth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener {

                if(it.isSuccessful){
                    toast("Signed in!")
                    val fbUser = it.result?.user
                    if(fbUser != null){
                        FirebaseDatabase.getInstance()
                            .getReference("users")
                            .child(fbUser.uid)
                            .setValue(MyAppUser().apply {
                                this.uid = fbUser.uid
                                this.fullName = fullName
                                this.email = email
                                this.age = age.toInt()
                            }).addOnCompleteListener { dbTask ->
                                hideProgress()
                                if(dbTask.isSuccessful){
                                    startActivity(Intent(this,ChatActivity::class.java))
                                    finish()
                                }else{
                                    toast("There was an error, please try again")
                                    fbUser.delete()
                                }
                            }
                    }else{
                        toast("There was an error, please try again")
                    }
                }else{
                    hideProgress()
                    toast("Error : ${it.exception?.message}")
                }
            }
    }

    private fun showProgress(){
        progressView.show()
        signUpBtn.hide()
    }

    private fun hideProgress(){
        progressView.hide()
        signUpBtn.show()
    }
}
