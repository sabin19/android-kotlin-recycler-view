package com.q.sabinks.kotlinerecyclerview

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.q.sabinks.kotlinerecyclerview.adapter.RecyclerViewAdapter
import com.q.sabinks.kotlinerecyclerview.models.ItemClass

class MainActivity : AppCompatActivity() {
    private var layoutManager: RecyclerView.LayoutManager?=null
    private var adapter: RecyclerViewAdapter? = null
    private var recyclcerView : RecyclerView? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        layoutManager = LinearLayoutManager(this)
        recyclcerView = findViewById(R.id.recyclerView) as RecyclerView
        adapter = RecyclerViewAdapter(initModel(),this,R.layout.item_recycler){
            toast("${it.name} Clicked")
        }
        recyclcerView?.layoutManager = layoutManager
        recyclcerView?.adapter = adapter


    }
    fun Context.toast(message: CharSequence) =
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    fun initModel(): ArrayList<ItemClass>{
        val myList: ArrayList<ItemClass> = ArrayList<ItemClass>()
        for (i in 1..12) run {
            val item: ItemClass = ItemClass(i,"name ${i}","This test content of name ${i}")
            myList.add(item)
        }
        return myList
    }
}
