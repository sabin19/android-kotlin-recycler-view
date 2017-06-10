package com.q.sabinks.kotlinerecyclerview.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.q.sabinks.kotlinerecyclerview.models.ItemClass
import kotlinx.android.synthetic.main.item_recycler.view.*

/**
 * Created by Sabin K.S on 5/25/2017.
 *
 */
class RecyclerViewAdapter(private val list: ArrayList<ItemClass>,private val context: Context,private val layout: Int,val listener: (ItemClass)->Unit): RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    override fun getItemCount(): Int {
       return list.size
    }
    override fun onBindViewHolder(p0: ViewHolder?, p1: Int) {
       p0?.onBind(list[p1],listener )
    }
    override fun onCreateViewHolder(p0: ViewGroup?, p1: Int): ViewHolder {
       return ViewHolder(LayoutInflater.from(p0?.context).inflate(layout,p0,false))
    }
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun onBind(item: ItemClass, listener: (ItemClass)->Unit) = with(itemView){
            itemView.name.text = item.name
            itemView.content.text = item.content
            setOnClickListener{listener(item)}
        }

    }

}