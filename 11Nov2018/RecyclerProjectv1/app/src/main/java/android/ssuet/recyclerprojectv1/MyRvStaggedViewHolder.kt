package android.ssuet.recyclerprojectv1

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class MyRvStaggedViewHolder(myItem: View) : RecyclerView.ViewHolder(myItem) {
    val myIv : ImageView = myItem.findViewById(R.id.itemImage)
}