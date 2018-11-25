package android.ssuet.viewpager

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        myPager.adapter = MyPagerAdapter(supportFragmentManager, arrayListOf(
            Fragment1(),
            Fragment2()
        ))

        myTabs.setupWithViewPager(myPager)
    }
}
