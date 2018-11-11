package android.ssuet.recyclerprojectv1

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

class MyRvAdapter(val itemViewFile:Int,val data:ArrayList<String>,val onItemClick:(Int)->Unit) : RecyclerView.Adapter<MyRvViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyRvViewHolder {
        val itemView  = LayoutInflater.from(parent.context).inflate(itemViewFile,parent,false)
        return MyRvViewHolder(itemView)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: MyRvViewHolder, position: Int) {
        holder.myTv.text = data[position]
        holder.itemView.setOnClickListener {
            onItemClick(position)
        }
    }
}