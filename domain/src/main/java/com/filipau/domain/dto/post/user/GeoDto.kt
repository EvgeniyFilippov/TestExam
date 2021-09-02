package com.filipau.domain.dto.post.user

import java.io.Serializable

data class GeoDto(
    var lat: String = "",
    var lng: String = ""
) : Serializable