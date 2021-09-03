package com.filipau.domain.dto.user

import java.io.Serializable

data class UserDto(
    val address: AddressDto,
    var email: String = "",
    var id: Int = 0,
    var name: String = "",
    var phone: String = "",
    var username: String = "",
    var website: String = ""
) : Serializable