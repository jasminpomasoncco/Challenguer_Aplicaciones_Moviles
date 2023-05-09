package com.example.challenguer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ViewListado : AppCompatActivity() {

    lateinit var appDb:AppDataBase
    lateinit var Lista:List<tablePost>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_listado)

        appDb=AppDataBase.getDatabase(this)

        val recycler:RecyclerView=findViewById(R.id.recyclerPost)

        GlobalScope.launch(Dispatchers.IO){
            Lista=appDb.postDao().getAll()
        }

        recycler.layoutManager=LinearLayoutManager(applicationContext)
        recycler.adapter=Adapter(Lista)
    }
}