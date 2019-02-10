package com.ishaquehassan.chatroom

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    lateinit var auth: FirebaseAuth
    lateinit var imgRef: StorageReference
    lateinit var dbRef: DatabaseReference

    private val PICK_IMG = 123
    lateinit var imgUri: Uri

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        auth = FirebaseAuth.getInstance()
        imgRef = FirebaseStorage.getInstance().getReference("images")
        dbRef = FirebaseDatabase.getInstance().getReference("users")

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

            if (emailText.isEmpty()) {
                emailEt.error = "Please enter email"
                isError = true
            }

            if (passText.isEmpty()) {
                passEt.error = "Please enter email"
                isError = true
            }

            if (fullNameText.isEmpty()) {
                fullNameEt.error = "Please enter Full Name"
                isError = true
            }

            if (ageText.isEmpty()) {
                ageEt.error = "Please enter Your Age"
                isError = true
            }

            if (!isError) {
                signIn(emailText, passText, fullNameText, ageText)
            }
        }

        signInTv.setOnClickListener {
            finish()
        }

        user_img.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.setType("image/*")
            startActivityForResult(Intent.createChooser(intent, "Select Imaage"), PICK_IMG)
        }
    }

    private fun signIn(email: String, password: String, fullName: String, age: String) {
        showProgress()
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {

                if (it.isSuccessful) {
                    toast("Signed in!")
                    val fbUser = it.result?.user


                    if (fbUser != null) {
                        FirebaseDatabase.getInstance()
                            .getReference("users")
                            .child(fbUser.uid)
                            .setValue(MyAppUser().apply {
                                this.uid = fbUser.uid
                                this.fullName = fullName
                                this.email = email
                                this.age = age.toInt()
                            }).addOnCompleteListener { dbTask ->
                                if (dbTask.isSuccessful) {
                                    uploadImage(fbUser?.uid ?: "")
                                } else {
                                    hideProgress()
                                    toast("There was an error, please try again")
                                    fbUser.delete()
                                }
                            }
                    } else {
                        toast("There was an error, please try again")
                    }
                } else {
                    hideProgress()
                    toast("Error : ${it.exception?.message}")
                }
            }
    }

    private fun showProgress() {
        progressView.show()
        signUpBtn.hide()
    }


    private fun hideProgress() {
        progressView.hide()
        signUpBtn.show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 123 && resultCode == Activity.RESULT_OK) {
            if (data != null) {
                imgUri = data.data
                user_img.setImageURI(imgUri)
            }
        }
    }

    fun uploadImage(id: String) {

        imgRef = imgRef.child(id + ".jpg")

        val task = imgRef.putFile(imgUri)
        task.addOnCompleteListener {

            if (it.isSuccessful) {
                imgRef.downloadUrl.addOnCompleteListener {d ->
                    val imgStr=d.result?.toString()
                    Log.e("url",imgStr)
                    hideProgress()
                    dbRef.child(id).child("image").setValue(imgStr)
                    startActivity(Intent(this, Profile::class.java))
                    finish()
                }
            }

        }
    }
}
