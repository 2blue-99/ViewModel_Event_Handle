package com.example.viewmodel_event

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    private var _myData = MutableLiveData("0")
    val myData:LiveData<String> get() = _myData

    init {
        viewModelScope.launch {
            repeat(10){
                _myData.value = _myData.value + 1
                Log.e("TAG", "value : ${_myData.value}", )
                delay(500)
            }
        }
    }
    fun rs(){

    }
}