package com.ishaquehassan.firebasedb

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.google.firebase.database.*
import com.ishaquehassan.firebasedb.models.ItemModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivityWithModel : AppCompatActivity(), ChildEventListener {
    override fun onCancelled(error: DatabaseError) {

    }

    override fun onChildMoved(dataSnap: DataSnapshot, raw: String?) {

    }

    override fun onChildChanged(dataSnap: DataSnapshot, raw: String?) {
        val key = dataSnap.key
        val myVal = dataSnap.getValue(ItemModel::class.java)
        if (myVal != null) {
            val myItemIndex = myFireData.indexOf(myVal)
            if(myItemIndex >= 0){
                myFireData.set(myItemIndex,myVal)
                myDataRv.adapter?.notifyItemChanged(myItemIndex)
            }
        }
    }

    override fun onChildRemoved(dataSnap: DataSnapshot) {
        val key = dataSnap.key
        val myVal = dataSnap.getValue(ItemModel::class.java)
        if (myVal != null) {
            val myItemIndex = myFireData.indexOf(myVal)
            if(myItemIndex >= 0){
                myFireData.removeAt(myItemIndex)
                myDataRv.adapter?.notifyItemRemoved(myItemIndex)
            }
        }

    }


    override fun onChildAdded(dataSnap: DataSnapshot, raw: String?) {
        val key = dataSnap.key
        val myVal = dataSnap.getValue(ItemModel::class.java)
        if (myVal != null) {
            myFireData.add(myVal)
            myDataRv.adapter?.notifyItemInserted(myFireData.size - 1)
        }
    }

    lateinit var myFireData: ArrayList<ItemModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myFireData = arrayListOf()

        myDataRv.adapter = FirebaseDataAdapterWithModel(myFireData)
        myDataRv.layoutManager = LinearLayoutManager(this)

        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("message")

        myRef.addChildEventListener(this)

        myBtn.setOnClickListener {
            val str = myEt.text.toString()
            if (str.isEmpty()) {
                myEt.error = "Please enter value!"
                return@setOnClickListener
            }
            val myPushId = myRef.push().key

            myRef.child(myPushId ?: "").setValue(ItemModel().apply {
                id = (myPushId ?: "-")
                value = str
            })
            myEt.setText("")
        }


    }
}
