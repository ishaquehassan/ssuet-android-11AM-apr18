package android.ssuet.recyclerprojectv1

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView

class MyRvViewHolder(myItem: View) : RecyclerView.ViewHolder(myItem) {
    val myTv : TextView = myItem.findViewById(R.id.myItemTv)
}