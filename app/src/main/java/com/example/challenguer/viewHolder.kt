package com.example.challenguer

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class viewHolder(view: View):RecyclerView.ViewHolder(view){
    val id=view.findViewById<TextView>(R.id.txtCardID)
    val Userid=view.findViewById<TextView>(R.id.txtUserID)
    val title=view.findViewById<TextView>(R.id.txttitle)
    val body=view.findViewById<TextView>(R.id.txtbody)

    fun render(postModel:tablePost){
        id.text=postModel.id.toString()
        Userid.text=postModel.userId.toString()
        title.text=postModel.title.toString()
        body.text=postModel.body.toString()
    }
}