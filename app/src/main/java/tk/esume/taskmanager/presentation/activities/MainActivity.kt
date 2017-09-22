package tk.esume.taskmanager.presentation.activities

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import co.zsmb.materialdrawerkt.builders.accountHeader
import co.zsmb.materialdrawerkt.builders.drawer
import co.zsmb.materialdrawerkt.draweritems.badgeable.primaryItem
import co.zsmb.materialdrawerkt.draweritems.profile.profile
import kotlinx.android.synthetic.main.activity_main.*
import tk.esume.taskmanager.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        floatingActionButton.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
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
}