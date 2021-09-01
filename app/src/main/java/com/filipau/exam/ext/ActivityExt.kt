package com.filipau.exam.ext

import android.app.Activity
import android.app.AlertDialog
import com.filipau.exam.R

fun Activity.showAlertDialog() {
    val alertDialog = AlertDialog.Builder(this)
        .setTitle(getString(R.string.error))
        .setMessage(getString(R.string.error_default))
        .setPositiveButton(getString(R.string.dialog_ok)) { dialog, _ ->
            dialog.dismiss()
        }
    alertDialog?.show()
}