package com.example.challenguer

import Beans.Post
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ViewUpdate : AppCompatActivity() {

    lateinit var appDb: AppDataBase
    //lateinit var Lista: List<tablePost>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_update)

        lateinit var post: Post
        appDb = AppDataBase.getDatabase(this)

        val regPost=tablePost(post.id, post.userId, post.title, post.body)
        GlobalScope.launch(Dispatchers.IO){
            appDb.postDao().updatePost(regPost)
        }

        val btnAccept: Button = findViewById(R.id.btnAccept)
        btnAccept.setOnClickListener() {
            val intent = Intent(this, ViewListado::class.java)
            startActivity(intent)
        }
    }
}