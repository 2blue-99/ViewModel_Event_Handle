package com.example.viewmodel_event

sealed class MyEvent {
    data class ShowPopup(val message: PopupContent, val callBack: () -> Unit): MyEvent()
    data class ShowToast(val message: String): MyEvent()
    data class MovePage(val id: Int): MyEvent()
}
