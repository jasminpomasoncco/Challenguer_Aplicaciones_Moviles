package com.example.challenguer

import Beans.Post
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class OptionsItem: AppCompatActivity() {
    lateinit var appDb: AppDataBase
    lateinit var post: Post


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item)

        appDb = AppDataBase.getDatabase(this)

        GlobalScope.launch(Dispatchers.IO) {

        }

        val btnUpdate: Button = findViewById(R.id.btnUpdate)
        btnUpdate.setOnClickListener() {
            val intent = Intent(this, ViewUpdate::class.java)
            startActivity(intent)
        }

        val btnDelete: Button = findViewById(R.id.btnDelete)
        btnDelete.setOnClickListener() {
            GlobalScope.launch(Dispatchers.IO) {
                val postList = appDb.postDao().getAll()
                val regPost = postList.find { it.id == post.id }
                if (regPost != null) {
                    appDb.postDao().deletePost(regPost)
                }
            }
        }
    }
}


