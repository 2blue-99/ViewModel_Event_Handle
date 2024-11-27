package com.example.viewmodel_event

sealed class MyEvent {
    data class ShowPopup(val content: PopupContent): MyEvent(), EventDelegator<Boolean> by DelegatedEvent()
    data class ShowToast(val message: String): MyEvent()
    data class MovePage(val id: Int): MyEvent()
}
