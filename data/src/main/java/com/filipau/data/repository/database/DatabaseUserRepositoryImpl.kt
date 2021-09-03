package com.filipau.data.repository.database

import com.filipau.data.ext.convertUserDtoToEntity
import com.filipau.data.room.DatabaseInfo
import com.filipau.domain.dto.room.RoomUserDto
import com.filipau.domain.repository.DatabaseUserRepository

class DatabaseUserRepositoryImpl(private val db: DatabaseInfo) : DatabaseUserRepository {

    override fun add(user: RoomUserDto) =
        db.getUserDAO().add(user.convertUserDtoToEntity())

}