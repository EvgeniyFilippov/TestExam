package com.filipau.exam.utils

import com.google.android.libraries.maps.CameraUpdateFactory
import com.google.android.libraries.maps.GoogleMap
import com.google.android.libraries.maps.model.LatLng
import com.google.android.libraries.maps.model.MarkerOptions

private lateinit var currentUserLatLng: LatLng
private var googleMap: GoogleMap? = null

fun initMap(
    map: GoogleMap,
    lat: String,
    lng: String
) {
    currentUserLatLng = LatLng(lat.toDouble(), lng.toDouble())

    googleMap = map.apply {

        val cameraLocation = CameraUpdateFactory.newLatLngZoom(currentUserLatLng, 7.0f)
        moveCamera(cameraLocation)
    }
    addMarkerOnMap(currentUserLatLng)
}

private fun addMarkerOnMap(markerPosition: LatLng) {
    val markerOptions = MarkerOptions()
        .position(markerPosition)
    googleMap?.addMarker(markerOptions)
}