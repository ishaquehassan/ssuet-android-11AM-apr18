package understandingui.android.ssuet.classcode

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        findViewById<TextView>(R.id.myNameTv).text = """
                    AGE : ${intent.getIntExtra(ViewsActivity.MY_AGE_KEY,0)}
                    NAME : ${intent.getStringExtra(ViewsActivity.MY_NAME_KEY)}
                """.trimIndent()
    }
}
