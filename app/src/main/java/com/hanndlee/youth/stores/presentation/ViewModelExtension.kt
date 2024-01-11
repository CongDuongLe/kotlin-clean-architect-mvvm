package com.hanndlee.youth.stores.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hanndlee.youth.utils.EventBus
import kotlinx.coroutines.launch

fun ViewModel.sendEvent(event: Any) {
    viewModelScope.launch {
        EventBus.sendEvent(event)
    }
}
