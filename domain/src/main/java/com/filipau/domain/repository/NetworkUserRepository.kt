package com.filipau.domain.repository

import com.filipau.domain.dto.user.UserDto
import com.filipau.domain.outcome.Outcome
import kotlinx.coroutines.flow.Flow

interface NetworkUserRepository {

    fun getListOfUsers(id: String): Flow<Outcome<UserDto>>

}