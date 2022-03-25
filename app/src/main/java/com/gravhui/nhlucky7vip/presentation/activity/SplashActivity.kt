package com.gravhui.nhlucky7vip.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.dakulangsakalam.customwebview.presentation.ui.jump.JumpActivity
import com.gravhui.nhlucky7vip.R
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class SplashActivity : JumpActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed({
            splashAction { _, _ ->
                startActivity(MainActivity.createIntent(this))
            }
        }, 1500)
    }
}