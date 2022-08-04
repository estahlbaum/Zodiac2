package com.hfad.tasks
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hfad.tasks.network.TaskApi
import kotlinx.coroutines.launch
class TasksViewModel(val dao: TaskDao) : ViewModel() {
    private val _status = MutableLiveData<String>()
    val status: LiveData<String> = _status
    init{
        getZodiacInfo()
    }
    var newTaskName = ""
    val tasks = dao.getAll()
    private val _navigateToTask = MutableLiveData<Long?>()
    val navigateToTask: LiveData<Long?>
        get() = _navigateToTask


    fun onTaskClicked(sunsign: Long) {
        _navigateToTask.value = sunsign
    }
    fun onTaskNavigated() {
        _navigateToTask.value = null
    }
    private fun getZodiacInfo(){
        viewModelScope.launch{
            try {
                val listAries = TaskApi.retrofitService.getSign(_navigateToTask.value)
                _status.value = listAries.toString()
            }catch (e: Exception) {
                _status.value = "Failure: ${e.message}"
            }
        }
    }
}