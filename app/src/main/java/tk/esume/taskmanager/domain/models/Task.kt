package tk.esume.taskmanager.domain.models

import java.util.*

data class Task(
    var title: String = "",
    var date: Date? = null,
    var done: Boolean = false
)
