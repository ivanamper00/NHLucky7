package com.dakuinternational.common.ui.event

open class UiEvent {

    object Success : UiEvent()

    data class Loading(val isLoading: Boolean) : UiEvent()

    data class Error(val error: Throwable? = null) : UiEvent()
}