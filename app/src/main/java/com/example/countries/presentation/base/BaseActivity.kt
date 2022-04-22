package com.example.countries.presentation.base

import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.countries.app.helper.showSimpleDialog
import dagger.android.AndroidInjection
import javax.inject.Inject

open
class BaseActivity<T : BasePresenter<out BaseView>> : AppCompatActivity() {

    @field:Inject
    lateinit var presenter: T

    var isErrorShown = false
    private val dismissListener = DialogInterface.OnDismissListener { isErrorShown = false }

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(newBase)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

    }

    override fun onStart() {
        super.onStart()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        presenter.detach()
        super.onDestroy()
    }

    open fun showMessage(message: String) {
        if (isErrorShown)
            return
        else isErrorShown = true
        showSimpleDialog(this, message, dismissListener = dismissListener)
    }

    open fun showLoading() {

    }

    open fun hideLoading() {

    }
}