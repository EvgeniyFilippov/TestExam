package com.filipau.domain.dto.post.user

import java.io.Serializable

data class AddressDto(
    var city: String = "",
    val geo: GeoDto,
    val street: String = "",
    val suite: String = "",
    val zipcode: String = ""
) : Serializable