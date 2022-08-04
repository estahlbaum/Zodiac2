package com.hfad.tasks

import androidx.recyclerview.widget.DiffUtil

class TaskDiffItemCallback : DiffUtil.ItemCallback<Task>() {
    override fun areItemsTheSame(oldItem: Task, newItem: Task)
            = (oldItem.sunsign == newItem.sunsign)
    override fun areContentsTheSame(oldItem: Task, newItem: Task) = (oldItem == newItem)
}