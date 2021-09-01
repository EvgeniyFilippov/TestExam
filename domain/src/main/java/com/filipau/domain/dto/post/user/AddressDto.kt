package com.filipau.domain.dto.post.user

data class AddressDto(
    val city: String = "",
    val geo: GeoDto,
    val street: String = "",
    val suite: String = "",
    val zipcode: String = ""
)