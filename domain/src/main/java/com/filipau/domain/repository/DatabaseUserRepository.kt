package com.filipau.domain.repository

import com.filipau.domain.dto.room.RoomUserDto

interface DatabaseUserRepository {

    fun add(user: RoomUserDto)

}