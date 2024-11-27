package com.example.viewmodel_event

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.coroutineContext

abstract class BaseViewModel: ViewModel() {
    private val _eventFlow = MutableSharedFlow<MyEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    suspend fun emitEvent(event: MyEvent){
        viewModelScope.launch {
            _eventFlow.emit(event)
        }
    }

    suspend fun <T> awaitEvent(event: EventDelegator<T>): T? {
        if(event is MyEvent){
            emitEvent(event)
        }
        return withContext(coroutineContext){
            val gap = event.result()
            return@withContext gap
        }
    }
}