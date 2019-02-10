package com.ishaquehassan.chatroom

import android.content.Context
import android.view.View
import android.widget.Toast

fun Context.toast(msg:String?){
    Toast.makeText(this,msg ?: "",Toast.LENGTH_LONG).show()
}

fun View.show(){
    visibility = View.VISIBLE
}
fun View.hide(){
    visibility = View.GONE
}