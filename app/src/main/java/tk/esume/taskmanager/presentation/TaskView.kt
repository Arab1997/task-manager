package tk.esume.taskmanager.presentation

interface TaskView {
    fun displayTitle(title: String)
    fun displayTime(timeString: String?)
    fun setAdditionalParamsVisible(visible: Boolean)
}