package com.filipau.domain.dto.room

import java.io.Serializable

data class RoomUserDto(
    var id: Int = 0,
    var name: String = "",
    var username: String = "",
    var email: String = "",
    var website: String = "",
    var phone: String = "",
    var city: String = ""
) : Serializable