package com.filipau.data.ext

import com.filipau.data.room.UserEntity
import com.filipau.domain.dto.room.RoomUserDto

fun RoomUserDto.convertUserDtoToEntity(): UserEntity {

    return UserEntity(
        this.id,
        this.name,
        this.username,
        this.email,
        this.website,
        this.phone,
        this.city
    )

}