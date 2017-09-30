package tk.esume.taskmanager.presentation.dialogs

import android.app.Dialog
import android.content.Context
import android.view.View
import kotlinx.android.synthetic.main.dialog_datetime_picker.*
import tk.esume.taskmanager.R
import java.util.*

class DateTimePickerDialog : Dialog {
    var onDateTimeSelectedListener : ((Calendar, Boolean) -> Unit)? = null

    private var currentView = Picker.DATE
        set(value) {
            field = value

            when (field) {
                Picker.DATE -> {
                    timePicker.visibility = View.GONE
                    datePicker.visibility = View.VISIBLE

                    setTimeButton.visibility = View.VISIBLE

                    okButton.setOnClickListener(dateViewOkListener)
                    cancelButton.setOnClickListener(dateViewCancelListener)
                }
                Picker.TIME -> {
                    datePicker.visibility = View.GONE
                    timePicker.visibility = View.VISIBLE

                    setTimeButton.visibility = View.GONE

                    okButton.setOnClickListener(timeViewOkListener)
                    cancelButton.setOnClickListener(timeViewCancelListener)
                }
            }
        }
    private var selectedDateTime = Calendar.getInstance()
    private var timeSelected = false

    private val dateViewOkListener : (View) -> Unit = {
        with(selectedDateTime) {
            set(Calendar.DAY_OF_MONTH, datePicker.dayOfMonth)
            set(Calendar.MONTH, datePicker.month)
            set(Calendar.YEAR, datePicker.year)
        }

        onDateTimeSelectedListener?.invoke(selectedDateTime, timeSelected)
        dismiss()
    }
    private val dateViewCancelListener : (View) -> Unit = {
        cancel()
    }
    private val timeViewOkListener : (View) -> Unit = {
        timeSelected = true

        currentView = Picker.DATE
    }
    private val timeViewCancelListener : (View) -> Unit = {
        timeSelected = false

        currentView = Picker.DATE
    }

    private constructor(context: Context) : super(context) {
        setContentView(R.layout.dialog_datetime_picker)

        setTimeButton.setOnClickListener {
            currentView = Picker.TIME
        }
        timePicker.setOnTimeChangedListener { view, hourOfDay, minute ->
            with(selectedDateTime) {
                set(Calendar.HOUR_OF_DAY, hourOfDay)
                set(Calendar.MINUTE, minute)
            }
        }
        okButton.setOnClickListener(dateViewOkListener)
        cancelButton.setOnClickListener(dateViewCancelListener)
    }

    class Builder(private val context: Context) {
        fun build() = DateTimePickerDialog(context)
    }

    private enum class Picker {
        DATE,
        TIME
    }
}