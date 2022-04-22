package com.example.countries.presentation.base

open class BasePresenter<T : BaseView>  {

    var view: T? = null

    protected var isFirstAttach: Boolean = true

    fun attach(view: T) {
        this.view = view
        if (isFirstAttach) {
            onFirstAttach()
            isFirstAttach = false
        } else {
            onNextAttach()
        }
    }

    protected open fun onFirstAttach() {

    }

    protected open fun onNextAttach() {

    }

    fun detach() {
        onDetach()
        view = null
    }

    protected open fun onDetach() {

    }

}