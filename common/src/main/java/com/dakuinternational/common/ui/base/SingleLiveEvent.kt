package com.dakuinternational.common.ui.base

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import java.util.concurrent.atomic.AtomicBoolean

open class SingleLiveEvent<T> : MutableLiveData<T>() {

    private val _pending = AtomicBoolean(false)

    override fun observe(owner: LifecycleOwner, observer: Observer<in T>) {
        super.observe(owner) {
            if (_pending.compareAndSet(true, false)) {
                observer.onChanged(it)
            }
        }
    }

    override fun setValue(value: T?) {
        _pending.set(true)
        super.setValue(value)
    }

    fun call() {
        value = null
    }
}
