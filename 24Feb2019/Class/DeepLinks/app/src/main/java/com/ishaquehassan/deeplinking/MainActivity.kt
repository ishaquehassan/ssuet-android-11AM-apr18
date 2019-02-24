package com.ishaquehassan.deeplinking

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val path = intent?.data?.path ?: ""
        if (!path.isEmpty()){
            val segments = path.split("/")
            val id = segments.last()
            Toast.makeText(this,id,Toast.LENGTH_SHORT).show()
        }
    }
}
