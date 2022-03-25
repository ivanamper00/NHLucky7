package com.dakuinternational.common.ui.binding

import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

fun <T : ViewBinding> AppCompatActivity.viewBinding(
    bindingInflater: (LayoutInflater) -> T
) = ActivityViewBindingDelegate(this, bindingInflater)

class ActivityViewBindingDelegate<T : ViewBinding>(
    val activity: AppCompatActivity,
    val viewBindingFactory: (LayoutInflater) -> T
) : ReadOnlyProperty<AppCompatActivity, T> {

    private var binding: T? = null

    init {
        activity.lifecycle.addObserver(object : DefaultLifecycleObserver {
            override fun onCreate(owner: LifecycleOwner) {
                super.onCreate(owner)
                activity.setContentView(binding?.root)
            }
        })
    }

    override fun getValue(thisRef: AppCompatActivity, property: KProperty<*>): T {
        val binding = binding

        if (binding != null) {
            return binding
        }

        val lifecycle = activity.lifecycle

        if (!lifecycle.currentState.isAtLeast(Lifecycle.State.INITIALIZED)) {
            throw IllegalStateException("Should not attempt to get bindings when Fragment views are destroyed.")
        }

        return viewBindingFactory(activity.layoutInflater).also { this.binding = it }
    }
}
