package com.hanndlee.youth.stores.presentation.screens.location_screen

import android.Manifest
import android.content.Context
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.hanndlee.youth.MainActivity
import com.hanndlee.youth.stores.domain.model.LocationData
import com.hanndlee.youth.utils.location.LocationUtils

@Composable
fun LocationScreen(navController: NavHostController) {

    val viewModel : LocationViewModel = viewModel()

    val locationState by viewModel.location



    val context = LocalContext.current
    val locationUtils = LocationUtils(context)

    Text(text = "HomeScreen")
    Spacer(modifier = Modifier.height(16.dp))
    LocationDisplay(locationUtils = locationUtils, context = context, viewModel = viewModel, locationState = locationState)


}


@Composable
fun LocationDisplay(
    locationUtils: LocationUtils,
    context: Context,
    viewModel: LocationViewModel,
    locationState: LocationData?,
) {

    val hasLocationPermission = locationUtils.hasLocationPermission(context)

    val requestPermissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestMultiplePermissions(),
        onResult = { permissions ->
            if (
                permissions[Manifest.permission.ACCESS_COARSE_LOCATION] == true
                && permissions[Manifest.permission.ACCESS_FINE_LOCATION] == true
            ) {
                locationUtils.updateLocation(viewModel = viewModel)

            } else {

                val retionaleRequired = ActivityCompat.shouldShowRequestPermissionRationale(
                    context as MainActivity,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ) || ActivityCompat.shouldShowRequestPermissionRationale(
                    context as MainActivity,
                    Manifest.permission.ACCESS_FINE_LOCATION
                )

                if (retionaleRequired) {
                    Toast.makeText(context, "Permission denied", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(context, "Permission denied, check in setting", Toast.LENGTH_LONG).show()
                }

            }
        }
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        if (locationState != null) {
            Text(text = "latitude: ${locationState.latitude}")
            Text(text = "longitude: ${locationState.longitude}")
        } else {
            Text(text = "location is not available")
        }

        Button(onClick = {
            if (hasLocationPermission) {

                locationUtils.updateLocation(viewModel = viewModel)
            } else {

                requestPermissionLauncher.launch(
                    arrayOf(
                        Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.ACCESS_FINE_LOCATION
                    )
                )
            }
        }) {
            Text(text = "Request location permission")
        }
    }
}
