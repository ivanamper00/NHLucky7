package com.dakuinternational.common.ui.base

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.dakuinternational.common.ui.dialog.LoadingDialog

abstract class BaseActivity: AppCompatActivity(){

    private var loadingDialog: LoadingDialog? = null


    fun showLoading(isLoading: Boolean){
        if(isLoading) getLoadingDialog()?.show()
        else getLoadingDialog()?.hide()
    }

    fun getLoadingDialog(): LoadingDialog? {
        if(loadingDialog == null) loadingDialog = LoadingDialog(this)
        return loadingDialog
    }
}