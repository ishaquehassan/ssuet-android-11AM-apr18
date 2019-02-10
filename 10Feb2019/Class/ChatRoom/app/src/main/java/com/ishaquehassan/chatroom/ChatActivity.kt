package com.ishaquehassan.chatroom

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.ishaquehassan.recyclerviewgeneraladapter.RecyclerViewGeneralAdapter
import kotlinx.android.synthetic.main.activity_chat.*

class ChatActivity : AppCompatActivity(),ChildEventListener {

    lateinit var auth: FirebaseAuth
    lateinit var chatNodeRef: DatabaseReference
    var myProfile:MyAppUser? = null
    lateinit var chatMessages:ArrayList<MyChatMessage>
    lateinit var myChatAdapter:RecyclerViewGeneralAdapter<MyChatMessage>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)
        auth = FirebaseAuth.getInstance()
        chatMessages = arrayListOf()

        myChatAdapter = RecyclerViewGeneralAdapter(
            chatMessages,
            mapOf(
                1 to R.layout.in_msg_layout,
                2 to R.layout.out_msg_layout
            ),{_, itemData ->
               if(auth.currentUser?.uid != itemData.userId){
                   1
               }else{
                   2
               }
            }
        ){itemData, viewHolder ->
            val viewType = viewHolder.itemViewType
            val itemView = viewHolder.itemView
            if(viewType == 1) {
                itemView.findViewById<TextView>(R.id.msgUserNameTv).text = itemData.userName
            }
            itemView.findViewById<TextView>(R.id.msgTextTv).text = itemData.messageText
        }

        msgsList.adapter = myChatAdapter
        msgsList.layoutManager = LinearLayoutManager(this)

        if(auth.currentUser == null){
            exitChat()
            return
        }else{
            FirebaseDatabase.getInstance().getReference("users")
                .child(auth.currentUser?.uid ?: "")
                .addListenerForSingleValueEvent(object : ValueEventListener{
                    override fun onCancelled(p0: DatabaseError) {
                        exitChat()
                    }

                    override fun onDataChange(snapshot: DataSnapshot) {
                        myProfile = snapshot.getValue(MyAppUser::class.java)
                        if(myProfile == null){
                            exitChat()
                        }
                    }

                })
        }


        chatNodeRef = FirebaseDatabase.getInstance().getReference("chats")

        chatNodeRef.addChildEventListener(this)

        signOutBtn.setOnClickListener {
            exitChat()
        }

        sendBtn.setOnClickListener {
            val msgText = msgInputEt.text.toString()
            if(msgText.isEmpty()){
                msgInputEt.error = "Please enter a message!"
            }else{
                msgInputEt.error = null
                sendMessage(MyChatMessage().apply {
                    id=chatNodeRef.push().key
                    messageText = msgText
                    userId = auth.currentUser?.uid
                    userName = myProfile?.fullName
                })
            }
        }

    }

    private fun exitChat(){
        auth.signOut()
        startActivity(Intent(this,SignInActivity::class.java))
        finish()
    }

    private fun sendMessage(msg:MyChatMessage){
        chatNodeRef.child(msg.id ?: "-").setValue(msg)
        msgInputEt.setText("")
    }

    override fun onCancelled(p0: DatabaseError) {

    }

    override fun onChildMoved(p0: DataSnapshot, p1: String?) {

    }

    override fun onChildChanged(p0: DataSnapshot, p1: String?) {

    }

    override fun onChildAdded(p0: DataSnapshot, p1: String?) {
        val fbMsg = p0.getValue(MyChatMessage::class.java)
        if(fbMsg!=null){
            myChatAdapter.add(fbMsg)
            msgsList.scrollToPosition(myChatAdapter.itemCount-1)
        }
    }

    override fun onChildRemoved(p0: DataSnapshot) {

    }
}
