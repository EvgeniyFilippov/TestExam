package com.filipau.domain.repository

import com.filipau.domain.dto.room.RoomUserDto
import com.filipau.domain.dto.user.UserDto

interface DatabaseUserRepository {

    fun add(user: RoomUserDto)
}