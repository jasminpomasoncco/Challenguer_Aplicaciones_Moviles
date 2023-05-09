package com.example.challenguer

import Beans.Post
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import `interface`.PlaceHolderApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    lateinit var service: PlaceHolderApi
    lateinit var post: Post

    lateinit var appDb: AppDataBase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        appDb=AppDataBase.getDatabase(this)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create<PlaceHolderApi>(PlaceHolderApi::class.java)

        val txtId:EditText=findViewById(R.id.txtId)
        val btnConsultar:Button=findViewById(R.id.btnConsult)

        btnConsultar.setOnClickListener() {
            getPostId(txtId.text.toString().toInt())
            txtId.text.clear()
        }

        val btnRecord:Button=findViewById(R.id.btnRecord)
        btnRecord.setOnClickListener(){
            val regPost=tablePost(post.id, post.userId, post.title, post.body)
            GlobalScope.launch(Dispatchers.IO){
                appDb.postDao().insert(regPost)
            }

            val txtRes:TextView=findViewById(R.id.txtRes)
            txtRes.text="SE REGISTRO CON EXITO."
        }

        val btnList:Button=findViewById(R.id.btnList)
        btnList.setOnClickListener(){
            val intent=Intent(this, ViewListado::class.java)
            startActivity(intent)
           // if(s)
        }
    }




    fun getPostId(id:Int){
        service.getPostId(id).enqueue(object : Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                post=response?.body()!!
                val txtRes:TextView=findViewById(R.id.txtRes)
                txtRes.text="ID: "+post?.id.toString()+ "\n" +
                        "userId: "+post?.userId.toString()+ "\n" +
                        "Title: "+post?.title.toString()+ "\n" +
                        "Body: "+post?.body.toString()+ "\n"
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                t?.printStackTrace()
            }

        })
    }

}