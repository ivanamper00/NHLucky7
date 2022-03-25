package com.dakuinternational.common.ui.utils

import android.content.Context
import android.view.View
import android.view.ViewOutlineProvider
import android.widget.Toast
import com.dakuinternational.common.ui.dialog.LoadingDialog

fun clipToBackground(view: View) {
    view.outlineProvider = ViewOutlineProvider.BACKGROUND
    view.clipToOutline = true
}

fun Context.showToast(message: String) = Toast.makeText(this, message, Toast.LENGTH_SHORT)

