package android.ssuet.fragmentsstack

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),MyFragCallBack{
    override fun onFragItemClick(name: String) {
        toast("Frag name is $name")
    }

    fun Context.toast(msg:String){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
    }

    private lateinit var fm:FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fm = supportFragmentManager

        val firstFrag = Fragment1()

        /*firstFrag.apply {
            arguments = Bundle().apply {
                putString("name","Ishaq")
            }
        }*/

        val myFragArgs = Bundle()
        myFragArgs.putString("name","Ishaq")


        firstFrag.arguments = myFragArgs
        addFrag(firstFrag)



        changeFragBtn.setOnClickListener {
            replaceFrag(Fragment2())
        }

        prevFragBtn.setOnClickListener {
            val count = fm.backStackEntryCount
            toast("BackStack Count $count")
            //fm.popBackStack()
            if(count > 1){
                fm.popBackStack()
            }
        }
    }

    fun addFrag(fragment: Fragment) {
        val fTransaction = fm.beginTransaction()
        fTransaction.add(R.id.fragmentsContainer, fragment)
        fTransaction.addToBackStack(null)
        fTransaction.commit()
    }

    fun replaceFrag(fragment: Fragment) {
        val fTransaction = fm.beginTransaction()
        fTransaction.replace(R.id.fragmentsContainer, fragment)
        fTransaction.addToBackStack(null)
        fTransaction.commit()
    }

    override fun onBackPressed() {
        val count = fm.backStackEntryCount
        if(count > 1){
            fm.popBackStack()
        }else{
            super.onBackPressed()
        }
    }
}
