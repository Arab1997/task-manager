package tk.esume.taskmanager.presentation.presenters

import android.text.format.DateUtils
import tk.esume.taskmanager.domain.models.Task
import tk.esume.taskmanager.presentation.TaskView
import java.text.SimpleDateFormat

private val timeFormat = SimpleDateFormat("HH:mm")
private val dateFormat = SimpleDateFormat("dd.MM.yyyy HH:mm")

class TaskPresenter {

    fun displayTaskInView(task: Task, view: TaskView) {
        view.displayTitle(task.title)

        val additionalParamsVisible = task.date != null

        view.setAdditionalParamsVisible(additionalParamsVisible)

        if (!additionalParamsVisible) {
            return
        }

        task.date?.apply {
            val today = DateUtils.isToday(this.time)

            if (today) {
                view.displayTime(timeFormat.format(this))

            } else {
                view.displayTime(dateFormat.format(this))
            }
        }
    }
}