package com.dakuinternational.common.ui

import com.dakuinternational.common.ui.event.UiEvent

sealed class ActivityEvent: UiEvent() {
    data class Loading(val isLoading: Boolean): UiEvent()
    data class Error(val message: String): UiEvent()
}