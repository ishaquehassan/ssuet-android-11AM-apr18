package understandingui.android.ssuet.classcode

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class ViewsActivity : AppCompatActivity(),View.OnClickListener {

    companion object {
        val MY_NAME_KEY = "myName"
        val MY_AGE_KEY = "myAge"
    }

    lateinit var img:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_views)

        //val btnOne = findViewById(R.id.button1) as Button
        //val btnTwo = findViewById<Button>(R.id.button1)
        //val btnThree : Button = findViewById(R.id.button1)

        img = findViewById(R.id.myImg)

        val btn1 : Button = findViewById(R.id.button1)
        val btn2 : Button = findViewById(R.id.button2)
        val btnCngActv : Button = findViewById(R.id.buttonChangeActivity)

        /*btnOne.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                Toast.makeText(this@ViewsActivity,"hello world",Toast.LENGTH_SHORT).show()
            }
        })*/

        btn1.setOnClickListener(this)
        btn2.setOnClickListener(this)
        btnCngActv.setOnClickListener{v ->
            val i = Intent(this,SecondActivity::class.java)
            i.putExtra(MY_NAME_KEY,"Hello World From Views Activity")
            i.putExtra(MY_AGE_KEY,19)
            startActivity(i)
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            null -> {

            }
            R.id.button1 ->{
                Toast.makeText(this,"Btn 1",Toast.LENGTH_SHORT).show()
                img.setImageResource(android.R.drawable.ic_lock_lock)
            }
            R.id.button2 ->{
                Toast.makeText(this,"Btn 2",Toast.LENGTH_SHORT).show()
                img.setImageResource(android.R.drawable.ic_dialog_map)
            }
        }
    }

}
