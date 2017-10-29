package tk.esume.taskmanager.domain.models

import java.util.*

data class Task(
    var title: String = "",
    var date: Date = Date(),
    var done: Boolean = false
)
