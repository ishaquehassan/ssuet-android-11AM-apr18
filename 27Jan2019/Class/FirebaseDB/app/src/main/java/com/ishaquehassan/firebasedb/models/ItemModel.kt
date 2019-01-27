package com.ishaquehassan.firebasedb.models

class ItemModel(){
    lateinit var id:String
    lateinit var value:String
    override fun equals(other: Any?): Boolean {
        return if(other is ItemModel){
            other.id == id
        }else{
            false
        }
    }
}