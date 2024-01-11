package com.hanndlee.youth.utils.location

import android.annotation.SuppressLint
import android.content.Context
import androidx.core.content.ContextCompat
import android.content.pm.PackageManager
import android.os.Looper
import com.google.android.gms.location.*
import com.hanndlee.youth.stores.domain.model.LocationData
import com.hanndlee.youth.stores.presentation.screens.location_screen.LocationViewModel

class LocationUtils(context: Context) {

    private val _fusedLocationClient : FusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context)

    fun hasLocationPermission(context: Context): Boolean {
       if (ContextCompat.checkSelfPermission(
                context,
                android.Manifest.permission.ACCESS_FINE_LOCATION
              ) == PackageManager.PERMISSION_GRANTED &&
              ContextCompat.checkSelfPermission(
                context,
                android.Manifest.permission.ACCESS_COARSE_LOCATION
              ) == PackageManager.PERMISSION_GRANTED
         ) {
              return true
         }
          return false
    }

    @SuppressLint("MissingPermission")
    fun updateLocation(viewModel: LocationViewModel){
        val locationCallback = object : LocationCallback(){
            override fun onLocationResult(locationResult: LocationResult) {
                super .onLocationResult(locationResult)
                locationResult.lastLocation?.let {
                    val location = LocationData(it.latitude, it.longitude)
                    viewModel.setLocation(location)
                }
            }
        }

        val locationRequest = LocationRequest.Builder(
            LocationRequest.PRIORITY_HIGH_ACCURACY,
            1000
        ).build()

        _fusedLocationClient.requestLocationUpdates(
            locationRequest,
            locationCallback,
            Looper.getMainLooper()
        )


    }




}
