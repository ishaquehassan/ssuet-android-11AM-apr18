package android.ssuet.fragmentsreplacements

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragTrans = supportFragmentManager.beginTransaction()
        fragTrans.add(R.id.fragContainer,Frag1())
        fragTrans.addToBackStack(null)
        fragTrans.commit()

    }
}
