package com.hfad.tasks
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
@Dao
interface TaskDao {

    @Update
    suspend fun update(task: Task)

    @Insert
    suspend fun insert(task:Task)

    @Query("SELECT * FROM task_table WHERE sunsign = :key")
    fun get(key: String): LiveData<Task>
    @Query("SELECT * FROM task_table ORDER BY sunsign DESC")
    fun getAll(): LiveData<List<Task>>
    @Query("DELETE FROM task_table")
    suspend fun deleteAll()
}