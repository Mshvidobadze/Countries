package com.example.countries.app.helper

import android.content.Context
import android.content.DialogInterface
import android.view.ContextThemeWrapper
import androidx.appcompat.app.AlertDialog
import com.example.countries.R

fun showSimpleDialog(activity: Context, message: String, listener: DialogInterface.OnClickListener? = null, title: String? = null, dismissListener: DialogInterface.OnDismissListener? = null, positiveTextId: Int? = null) {
    val builder = AlertDialog.Builder(ContextThemeWrapper(activity, R.style.AlertDialogStyle))
        .setMessage(message)
        .setPositiveButton(positiveTextId ?: R.string.yes, listener)
        .setOnDismissListener(dismissListener)
    title?.let { builder.setTitle(it) }
    builder.show()
}