package com.example.challenguer

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class Adapter(val listaPost:List<tablePost>):RecyclerView.Adapter<viewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val layoutInflater=LayoutInflater.from(parent.context)
        return viewHolder(layoutInflater.inflate(R.layout.item,parent,false))
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val item=listaPost[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = listaPost.size


}