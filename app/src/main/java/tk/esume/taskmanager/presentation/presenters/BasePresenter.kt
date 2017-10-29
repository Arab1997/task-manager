package tk.esume.taskmanager.presentation.presenters

abstract class BasePresenter<ViewType> {
    var view : ViewType? = null
    var viewResumed = false

    open fun onViewCreated(view: ViewType) {
        this.view = view
    }

    open fun onViewResumed() {
        viewResumed = true
    }

    open fun onViewPaused() {
        viewResumed = false
    }

    open fun onViewDestroyed() {
        view = null
    }
}