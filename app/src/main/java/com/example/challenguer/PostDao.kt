package com.example.challenguer

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface PostDao {

    @Query("select * from post_table")
    fun getAll():List<tablePost>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(tablePost: tablePost)

    @Delete
    suspend fun deletePost(tablePost: tablePost)

    @Update
    suspend fun updatePost(table:tablePost)

}