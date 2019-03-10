package com.ishaquehassan.backgroundservices

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.support.v4.app.NotificationCompat
import android.widget.RemoteViews

class MyTestService : Service() {
    override fun onBind(intent: Intent): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        showNotification()
        return START_STICKY
    }

    private fun showNotification(){
        val notiLayout = RemoteViews(packageName,R.layout.noti_layout)
        val notiBigLayout = RemoteViews(packageName,R.layout.noti_layout_big)

        //notiBigLayout.setTextViewText(R.id.mySampleTv,"Hello world text from Service")

        val notificationIntent = Intent(this, MainActivity::class.java)

        val pendingIntent = PendingIntent.getActivity(this,   0,notificationIntent, 0)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel("1", "Media", NotificationManager.IMPORTANCE_HIGH)
            val m = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            m.createNotificationChannel(channel)
        }

        val noti = NotificationCompat.Builder(this, "1").apply {
            setCustomContentView(notiLayout)
            setCustomBigContentView(notiBigLayout)
            setContentIntent(pendingIntent)
            setSmallIcon(R.mipmap.ic_launcher)
            setContentTitle("Test")
            setContentText("Test")
            setOngoing(true)
        }.build()

        startForeground(10, noti)

    }
}
