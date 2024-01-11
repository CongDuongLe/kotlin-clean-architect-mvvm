package com.hanndlee.youth.stores.presentation.screens.location_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.hanndlee.youth.stores.domain.model.LocationData

class LocationViewModel: ViewModel() {
    private var _location = mutableStateOf<LocationData?>(null)

    var location : State<LocationData?> = _location

    fun setLocation(locationData: LocationData) {
        _location.value = locationData
    }

}
