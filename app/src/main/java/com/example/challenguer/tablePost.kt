package com.example.challenguer

import android.icu.text.CaseMap.Title
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import retrofit2.http.Body

@Entity(tableName = "post_table")
data class tablePost (
    @PrimaryKey()
    val id:Int?,

    @ColumnInfo(name = "userId")
    val userId:Int?,

    @ColumnInfo(name = "title")
    val title: String?,

    @ColumnInfo(name = "body")
    val body: String?,

    )