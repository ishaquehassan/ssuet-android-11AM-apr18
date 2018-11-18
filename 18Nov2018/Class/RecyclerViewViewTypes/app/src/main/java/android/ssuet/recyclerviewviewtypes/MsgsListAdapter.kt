package android.ssuet.recyclerviewviewtypes

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

class MsgsListAdapter(val msgs:ArrayList<MsgItem>) : RecyclerView.Adapter<MsgViewHolder>() {
    val MSG_IN = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MsgViewHolder {
        if(viewType == MSG_IN){
            return MsgViewHolderIn(LayoutInflater.from(parent.context).inflate(R.layout.msg_item,parent,false))
        }else {
            return MsgViewHolderOut(LayoutInflater.from(parent.context).inflate(R.layout.msg_item_out,parent,false))
        }
    }

    override fun getItemCount(): Int = msgs.size

    override fun onBindViewHolder(viewHolder: MsgViewHolder, position: Int) = viewHolder.bindItem(msgs[position])

    override fun getItemViewType(position: Int): Int {
        return msgs[position].msgSentBy
    }
}