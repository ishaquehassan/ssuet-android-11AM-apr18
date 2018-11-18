package android.ssuet.recyclerviewviewtypes

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var msgs:ArrayList<MsgItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        msgs = arrayListOf(
            MsgItem("Hello world",0),
            MsgItem("Hello world",1),
            MsgItem("Hello world",0),
            MsgItem("Hello world",1)
        )

        myMsgsList.layoutManager = LinearLayoutManager(this)
        myMsgsList.adapter = MsgsListAdapter(msgs)

        var sendingId = 1

        sendMsgBtn.setOnClickListener {
            val msgText = msgEt.text.toString()
            if(!msgText.isEmpty()){
                msgs.add(MsgItem(msgText,sendingId))
                if(sendingId == 1){
                    sendingId = 0
                }else{
                    sendingId = 1
                }
                msgEt.setText("")
                val lastPosition = msgs.size-1
                myMsgsList.adapter?.notifyItemInserted(lastPosition)
                myMsgsList.scrollToPosition(lastPosition)
            }
        }

    }
}
