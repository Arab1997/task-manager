package tk.esume.taskmanager.di

import dagger.Component
import tk.esume.taskmanager.presentation.activities.MainActivity
import javax.inject.Singleton

@Component(modules = arrayOf(MainModule::class))
@Singleton
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}