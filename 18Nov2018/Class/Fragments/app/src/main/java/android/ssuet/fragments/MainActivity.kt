package android.ssuet.fragments

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myFrag = getSupportFragmentManager().findFragmentById(R.id.frag1)
        if(myFrag is Fragment){
            (myFrag as BlankFragment).toast()
        }
    }
}
