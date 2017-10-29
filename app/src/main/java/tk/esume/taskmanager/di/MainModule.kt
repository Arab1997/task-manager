package tk.esume.taskmanager.di

import android.content.Context
import dagger.Module
import dagger.Provides
import tk.esume.taskmanager.presentation.adapters.TasksRecyclerViewAdapter
import tk.esume.taskmanager.presentation.presenters.InboxPresenter
import tk.esume.taskmanager.presentation.presenters.TaskPresenter
import javax.inject.Singleton

@Module
class MainModule(private val context: Context) {

    @Provides
    fun provideContext() = context

    @Provides
    @Singleton
    fun provideInboxPresenter() = InboxPresenter()

    @Provides
    @Singleton
    fun provideTaskPresenter() = TaskPresenter()

    @Provides
    @Singleton
    fun provideTasksRecyclerViewAdapter(context: Context, taskPresenter: TaskPresenter)
            = TasksRecyclerViewAdapter(context, taskPresenter)
}