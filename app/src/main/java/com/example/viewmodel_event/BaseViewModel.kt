package com.example.viewmodel_event

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel: ViewModel() {
    private val _eventFlow = MutableSharedFlow<MyEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    fun makeEvent(event: MyEvent){
        viewModelScope.launch {
            _eventFlow.emit(event)
        }
    }
}