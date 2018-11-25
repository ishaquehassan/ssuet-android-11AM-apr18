package android.ssuet.viewpager

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class MyPagerAdapter(fm:FragmentManager,val pages:ArrayList<Fragment>) : FragmentPagerAdapter(fm){
    override fun getItem(position: Int): Fragment = pages[position]
    override fun getCount(): Int = pages.size
    override fun getPageTitle(position: Int): CharSequence? = "Hello"
}