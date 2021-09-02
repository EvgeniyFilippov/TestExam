package com.filipau.exam.ui.map

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.filipau.exam.Constants
import com.filipau.exam.Constants.GEO_LAT_KEY
import com.filipau.exam.Constants.GEO_LNG_KEY
import com.filipau.exam.R
import com.filipau.exam.databinding.FragmentMapBinding
import com.filipau.exam.utils.initMap
import com.google.android.libraries.maps.SupportMapFragment

class MapFragment : Fragment(R.layout.fragment_map) {

    private var binding: FragmentMapBinding? = null
    private lateinit var userGeoLat: String
    private lateinit var userGeoLng: String
    var mapFragment: SupportMapFragment? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMapBinding.inflate(inflater, container, false)
        userGeoLat = arguments?.getString(GEO_LAT_KEY) ?: Constants.ERROR
        userGeoLng = arguments?.getString(GEO_LNG_KEY) ?: Constants.ERROR
        mapFragment =
            childFragmentManager.findFragmentById(R.id.mapFragmentContainer) as? SupportMapFragment?

        showMap(userGeoLat, userGeoLng)
        return binding?.root
    }

    private fun showMap(lat: String, lng: String) {
        mapFragment?.run {
            getMapAsync { map ->
                activity?.let {
                    initMap(map, lat, lng)
                }
            }
        }
    }

}