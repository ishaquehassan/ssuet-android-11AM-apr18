package com.ishaquehassan.firebasedb

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.ishaquehassan.firebasedb.models.ItemModel

class FirebaseDataAdapterWithModel(val data:ArrayList<ItemModel>) : RecyclerView.Adapter<FirebaseDataAdapterWithModel.MyFireViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyFireViewHolder = MyFireViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false))
    override fun getItemCount(): Int = data.size
    override fun onBindViewHolder(vh: MyFireViewHolder, pos: Int) = vh.bind(data[pos])
    inner class MyFireViewHolder(iv:View) : RecyclerView.ViewHolder(iv){
        val myItemTv = iv.findViewById<TextView>(R.id.myItemTv)

        fun bind(item:ItemModel){
            myItemTv.text = "${item.id} : ${item.value}"
        }

    }

}