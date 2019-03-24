package com.ishaquehassan.fcm

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService(){
    override fun onMessageReceived(remoteMessage: RemoteMessage?) {
        Log.e("onMessageReceived Data",remoteMessage?.data.toString())
        Log.e("onMessageReceived Noti",remoteMessage?.notification?.title ?: "-")

    }

    override fun onNewToken(token: String?) {
        Log.e("onNewToken",token)
    }
}