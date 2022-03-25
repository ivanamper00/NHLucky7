package com.dakuinternational.common.ui.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.ViewGroup
import com.dakuinternational.common.R
import com.dakuinternational.common.databinding.DialogLoadingBinding

class LoadingDialog(context: Context): Dialog(context) {

    lateinit var binding: DialogLoadingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DialogLoadingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setCancelable(false)
    }

    override fun onStart() {
        super.onStart()
        this.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        this.window?.setBackgroundDrawableResource(R.color.transparent)
    }
}   