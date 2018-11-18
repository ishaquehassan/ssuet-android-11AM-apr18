package android.ssuet.recyclerviewviewtypes

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView

class MsgViewHolderIn(myItem: View) : MsgViewHolder(myItem){
    val userNameTextView:TextView = itemView.findViewById(R.id.userNameTv)

    override fun bindItem(msgItem: MsgItem) {
        super.bindItem(msgItem)
        userNameTextView.text = "Hello world Arbaz"
    }
}