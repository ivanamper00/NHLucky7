package com.dakuinternational.common.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dakuinternational.common.data.repository.RepoImp
import com.dakuinternational.common.domain.model.DataContent
import com.dakuinternational.common.domain.model.Response
import com.dakuinternational.common.domain.use_case.UseCases
import com.dakuinternational.common.ui.base.SingleLiveEvent
import com.dakuinternational.common.ui.event.UiEvent
import com.dakuinternational.common.ui.utils.writeLog
import com.squareup.okhttp.Dispatcher
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject
import kotlin.coroutines.coroutineContext

@HiltViewModel
class ActivityViewModel @Inject constructor(
    private val useCases: UseCases
): ViewModel() {

    private val _uiState = SingleLiveEvent<Response<List<DataContent>>>()
    val uiState: LiveData<Response<List<DataContent>>> get() = _uiState

    fun getData(dbName: String){
        viewModelScope.launch {
            useCases.getAllData(dbName).onStart {
                _uiState.postValue(Response.Loading(true))
            }.collect {
                _uiState.postValue(Response.Loading(false))
                _uiState.value = it
            }
        }
    }

}