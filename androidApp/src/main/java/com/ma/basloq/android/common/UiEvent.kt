package com.ma.basloq.android.common

sealed class UiEvent {
    data class ShowSnackbar(val message: String): UiEvent()
    // todo : navigate to the empty screen or error
    data object NavigateUp: UiEvent()
}
