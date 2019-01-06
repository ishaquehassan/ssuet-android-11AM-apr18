package android.ssuet.dialogs

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class EmptyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_empty)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.slide_dow,R.anim.slide_up)
    }
}
