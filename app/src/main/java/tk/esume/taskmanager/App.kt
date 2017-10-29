package tk.esume.taskmanager

import android.app.Application
import tk.esume.taskmanager.di.AppComponent
import tk.esume.taskmanager.di.DaggerAppComponent
import tk.esume.taskmanager.di.MainModule

class App : Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
                .mainModule(MainModule(applicationContext))
                .build()
    }
}