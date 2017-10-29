package tk.esume.taskmanager.presentation.activities

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import co.zsmb.materialdrawerkt.builders.accountHeader
import co.zsmb.materialdrawerkt.builders.drawer
import co.zsmb.materialdrawerkt.draweritems.badgeable.primaryItem
import co.zsmb.materialdrawerkt.draweritems.profile.profile
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import org.jetbrains.anko.startActivity
import tk.esume.taskmanager.App
import tk.esume.taskmanager.R
import tk.esume.taskmanager.domain.models.Task
import tk.esume.taskmanager.presentation.InboxView
import tk.esume.taskmanager.presentation.adapters.TasksRecyclerViewAdapter
import tk.esume.taskmanager.presentation.presenters.InboxPresenter
import javax.inject.Inject

class MainActivity : AppCompatActivity(), InboxView {

    @Inject
    lateinit var presenter: InboxPresenter

    @Inject
    lateinit var tasksAdapter: TasksRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        App.appComponent.inject(this)

        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        floatingActionButton.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", { startActivity<TaskEditActivity>() }).show()
        }

        drawer {
            toolbar = this@MainActivity.toolbar

            accountHeader {
                background = R.color.primary

                profile("Username")
            }
            primaryItem(R.string.inbox_menu_item) {
                icon = R.drawable.ic_inbox_black_24dp
            }
            primaryItem(R.string.today_menu_item) {
                icon = R.drawable.ic_today_black_24dp
            }
            primaryItem(R.string.week_menu_item) {
                icon = R.drawable.ic_date_range_black_24dp
            }
            primaryItem(R.string.projects_menu_item) {
                icon = R.drawable.ic_list_black_24dp
            }
            primaryItem(R.string.settings_menu_item) {
                icon = R.drawable.ic_settings_black_24dp
            }
        }

        tasksView.layoutManager = LinearLayoutManager(this)
        tasksView.adapter = tasksAdapter
        presenter.onViewCreated(this)
    }

    override fun onResume() {
        super.onResume()

        presenter.onViewResumed()
    }

    override fun onPause() {
        super.onPause()

        presenter.onViewPaused()
    }

    override fun onDestroy() {
        presenter.onViewDestroyed()

        super.onDestroy()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId

        return if (id == R.id.action_settings) {
            true
        } else super.onOptionsItemSelected(item)
    }

    override fun showTasks(tasks: List<Task>) {
        tasksAdapter.items = tasks
    }
}
