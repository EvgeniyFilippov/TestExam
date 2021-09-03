package com.filipau.domain.dto.user

import java.io.Serializable

data class GeoDto(
    var lat: String = "",
    var lng: String = ""
) : Serializable