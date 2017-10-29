package tk.esume.taskmanager.presentation.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.item_task.view.*
import org.jetbrains.anko.layoutInflater
import tk.esume.taskmanager.R
import tk.esume.taskmanager.domain.models.Task
import tk.esume.taskmanager.presentation.TaskView
import tk.esume.taskmanager.presentation.presenters.TaskPresenter

class TasksRecyclerViewAdapter(private val context: Context, private val taskPresenter: TaskPresenter) : RecyclerView.Adapter<TasksRecyclerViewAdapter.TaskViewHolder>() {
    var items : List<Task> = ArrayList<Task>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: TaskViewHolder?, position: Int) {
        holder?.apply {
            taskPresenter.displayTaskInView(items[position], this)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): TaskViewHolder {
        val view = context.layoutInflater.inflate(R.layout.item_task, parent, false)
        return TaskViewHolder(view)
    }

    class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), TaskView {
        val taskTitleView: TextView = itemView.taskTitle
        val additionalParams: View = itemView.additionalParams
        val timeTextView: TextView = itemView.timeTextView

        override fun displayTitle(title: String) {
            taskTitleView.text = title
        }

        override fun displayTime(timeString: String?) {
            if (timeString != null) {
                timeTextView.visibility = View.VISIBLE
                timeTextView.text = timeString

            } else {
                timeTextView.visibility = View.GONE
            }
        }

        override fun setAdditionalParamsVisible(visible: Boolean) {
            additionalParams.visibility = if (visible) {
                View.VISIBLE
            } else {
                View.GONE
            }
        }
    }
}