package com.ishaquehassan.firebasedb

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(),ChildEventListener{
    override fun onCancelled(error: DatabaseError) {

    }

    override fun onChildMoved(dataSnap: DataSnapshot, raw: String?) {

    }

    override fun onChildChanged(dataSnap: DataSnapshot, raw: String?) {

    }

    override fun onChildRemoved(dataSnap: DataSnapshot) {

    }


    override fun onChildAdded(dataSnap: DataSnapshot, raw: String?) {
        val key = dataSnap.key
        val myValueMap = mutableMapOf(
            "id" to "-",
            "value" to ""
        )
        for (snap in dataSnap.children){
            myValueMap[snap.key ?: ""] = snap.getValue(String::class.java) ?: ""
        }
        myFireData.add(myValueMap)
        myDataRv.adapter?.notifyItemInserted(myFireData.size-1)
    }

    lateinit var myFireData:ArrayList<MutableMap<String,String>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myFireData = arrayListOf()

        myDataRv.adapter = FirebaseDataAdapter(myFireData)
        myDataRv.layoutManager = LinearLayoutManager(this)

        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("message")

        myRef.addChildEventListener(this)

        myBtn.setOnClickListener {
            val str = myEt.text.toString()
            if(str.isEmpty()){
                myEt.error = "Please enter value!"
                return@setOnClickListener
            }
            val myPushId = myRef.push().key

            val myValue = mapOf(
                "id" to (myPushId ?: "-"),
                "value" to str
            )

            myRef.child(myPushId ?: "").setValue(myValue)
            myEt.setText("")
        }


    }
}
