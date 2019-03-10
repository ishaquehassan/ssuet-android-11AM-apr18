package com.ishaquehassan.broadcastreceivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var receiver:BroadcastReceiver? = null
    lateinit var broadCastAction:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        broadCastAction = "$packageName.TestReceiver"
        sendBroadCastButton.setOnClickListener {
            sendBroadcast(Intent(broadCastAction).apply {
                putExtra("name","Student")
            })
        }
    }

    override fun onResume() {
        super.onResume()
        if (receiver == null){
            receiver = MyTestBroadCast()
        }
        registerReceiver(receiver, IntentFilter(broadCastAction))
    }

    override fun onStop() {
        super.onStop()
        if(receiver != null){
            unregisterReceiver(receiver)
        }
    }

    class MyTestBroadCast : BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {
            Toast.makeText(context,"Test Receiver From Activity ${intent?.getStringExtra("name")}",Toast.LENGTH_SHORT).show()
        }

    }
}
