package tk.esume.taskmanager.presentation.presenters

import tk.esume.taskmanager.domain.models.Task
import tk.esume.taskmanager.presentation.InboxView

class InboxPresenter : BasePresenter<InboxView>() {

    override fun onViewResumed() {
        super.onViewResumed()

        view?.apply {
            val tasksList = listOf(
                Task("Task 1"),
                Task("Task 2"),
                Task("Task 3")
            )
            showTasks(tasksList)
        }
    }
}