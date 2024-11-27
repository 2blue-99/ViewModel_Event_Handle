package com.example.viewmodel_event

import android.util.Log
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel: BaseViewModel() {

    fun onClickLogout(){
        viewModelScope.launch {
            val isAgree = awaitEvent(
                MyEvent.ShowPopup(content = PopupContent.NETWORK_ERR)
            )
            Log.e("TAG", "isAgree :$isAgree", )
            if(isAgree == true){
                // TODO 로그아웃 로직 실행
                Log.e("TAG", "onClickPopup: 로그아웃", )

                emitEvent(
                    MyEvent.ShowToast("로그아웃 완료")
                )
            }
        }
    }

    fun onClickToast(){
        viewModelScope.launch {
            emitEvent(MyEvent.ShowToast("Test"))
        }
    }

    fun onClickBack(){
        viewModelScope.launch {
            emitEvent(MyEvent.MovePage(R.id.testestest))
        }
    }
}