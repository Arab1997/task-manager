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

class TasksRecyclerViewAdapter(private val context: Context) : RecyclerView.Adapter<TasksRecyclerViewAdapter.TaskViewHolder>() {
    var items : List<Task> = ArrayList<Task>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: TaskViewHolder?, position: Int) {
        holder?.apply {
            val task = items[position]
            taskTitleView?.text = task.title
            timeTextView?.text = task.date.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): TaskViewHolder {
        val view = context.layoutInflater.inflate(R.layout.item_task, parent, false)
        return TaskViewHolder(view)
    }

    class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val taskTitleView: TextView? = itemView.taskTitle
        val timeTextView: TextView? = itemView.timeTextView
    }
}