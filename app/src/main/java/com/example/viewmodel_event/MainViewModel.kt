package com.example.viewmodel_event

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class MainViewModel: BaseViewModel() {

    fun onClickPopup(){
        makeEvent(MyEvent.ShowPopup(PopupContent.NETWORK_ERR, {}))
    }

    fun onClickToast(){
        makeEvent(MyEvent.ShowToast("Test"))
    }

    fun onClickBack(){
        makeEvent(MyEvent.MovePage(R.id.testestest))
    }
}