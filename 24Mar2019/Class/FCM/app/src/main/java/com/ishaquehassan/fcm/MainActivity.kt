package com.ishaquehassan.fcm

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.messaging.FirebaseMessaging

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        FirebaseMessaging.getInstance().subscribeToTopic("ssuet")
        FirebaseMessaging.getInstance().unsubscribeFromTopic("ssuet")
    }
}
