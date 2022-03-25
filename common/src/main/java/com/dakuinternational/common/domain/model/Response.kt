package com.dakuinternational.common.domain.model

sealed class Response<out T> {
    data class Loading(var isLoading: Boolean): Response<Nothing>()

    data class Success<out T>(
        val data: T
    ): Response<T>()

    data class Error(
        val message: String
    ): Response<Nothing>()
}
