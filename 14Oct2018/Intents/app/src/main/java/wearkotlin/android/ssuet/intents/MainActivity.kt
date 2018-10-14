package wearkotlin.android.ssuet.intents

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    val MY_NEW_MSG_INTENT_KEY = 100;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.gotoSecondActivity)
                .setOnClickListener {
                    val i = Intent(this,NewMessage::class.java)
                    startActivityForResult(i,MY_NEW_MSG_INTENT_KEY)
                }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode == MY_NEW_MSG_INTENT_KEY){
            if(resultCode == Activity.RESULT_OK){
                findViewById<TextView>(R.id.myDataTv).text = data?.getStringExtra("name")
            }else{
                Toast.makeText(this,"Please Press done btn!",Toast.LENGTH_SHORT).show()
            }
        }
    }
}
