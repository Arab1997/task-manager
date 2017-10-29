package tk.esume.taskmanager.presentation

import tk.esume.taskmanager.domain.models.Task

interface InboxView {
    fun showTasks(tasks: List<Task>)
}