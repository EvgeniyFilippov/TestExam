package com.filipau.domain.dto.post.user

import java.io.Serializable

data class GeoDto(
    val lat: String = "",
    val lng: String = ""
) : Serializable