package com.example.countries.presentation.base

import android.app.Activity
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.countries.app.helper.showSimpleDialog
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

abstract class BaseSupportFragment<T : BasePresenter<out BaseView>> : Fragment() {

    @field:Inject
    lateinit var presenter: T
    private val dismissListener = DialogInterface.OnDismissListener {
        if (activity != null)
            (activity as BaseActivity<*>).isErrorShown = false
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onAttach(activity: Activity) {
        AndroidSupportInjection.inject(this)
        super.onAttach(activity)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutId(), container, false)
    }

    override fun onDestroyView() {
        presenter.detach()
        super.onDestroyView()
    }

    abstract fun layoutId(): Int


    fun showMessage(messageId: Int, titleId: Int?) {
        activity?.let {
            if ((activity as BaseActivity<*>).isErrorShown)
                return@let
            else (activity as BaseActivity<*>).isErrorShown = true
            val title = if (titleId != null) getString(titleId) else null
            showSimpleDialog(it, getString(messageId), title = title, dismissListener = dismissListener)
        }
    }

    open fun showLoading() {
        (activity as BaseActivity<*>).showLoading()
    }

    open fun hideLoading() {
        (activity as BaseActivity<*>).hideLoading()
    }

}