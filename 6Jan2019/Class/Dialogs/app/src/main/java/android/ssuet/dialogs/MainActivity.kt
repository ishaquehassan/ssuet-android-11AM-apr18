package android.ssuet.dialogs

import android.app.Dialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        show.setOnClickListener{
            val dialog = CustomDialog(this)
            dialog.setCancelable(false)
            dialog.show()

            dialog.setOnDismissListener {

            }
           /* startActivity(Intent(this,EmptyActivity::class.java))
            overridePendingTransition(R.anim.slide_up,R.anim.slide_dow)*/


        }


    }
}
