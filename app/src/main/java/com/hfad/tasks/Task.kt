package com.hfad.tasks
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.lang.reflect.Array

@Entity(tableName = "task_table")
data class Task(

    @PrimaryKey val sunsign: String,
    val credit:String,
    val date:String,
    val horoscope:String
)