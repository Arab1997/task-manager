package tk.esume.taskmanager.presentation.activities

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_task_edit.*
import kotlinx.android.synthetic.main.content_task_edit.*

import tk.esume.taskmanager.R
import tk.esume.taskmanager.presentation.dialogs.DateTimePickerDialog
import java.text.SimpleDateFormat

class TaskEditActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_edit)
        setSupportActionBar(toolbar)

        floatingActionButton.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        supportActionBar?.apply {
            setHomeButtonEnabled(true)
            setDisplayHomeAsUpEnabled(true)
        }

        dueDateEdit.apply {
            keyListener = null
            setOnClickListener {
                val builder = DateTimePickerDialog.Builder(context)
                val dialog = builder.build()
                dialog.onDateTimeSelectedListener = {
                    calendar, timeSet ->
                    val dateFormat = SimpleDateFormat("HH:mm dd.MM.yyyy")
                    Log.d("TaskEditActivity", "${dateFormat.format(calendar.time)}, time selected = ${timeSet}")
                }
                dialog.show()
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean = when (item?.itemId) {
        android.R.id.home -> {
            finish()
            true
        }

        else -> super.onOptionsItemSelected(item)
    }
}
