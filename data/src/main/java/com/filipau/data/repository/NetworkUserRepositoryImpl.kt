package com.filipau.data.repository

import com.filipau.data.api.UsersService
import com.filipau.data.ext.modifyFlowOutcome
import com.filipau.data.ext.transformUserToDto
import com.filipau.domain.dto.post.user.UserDto
import com.filipau.domain.outcome.Outcome
import com.filipau.domain.repository.NetworkUserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class NetworkUserRepositoryImpl(private val mService: UsersService) :
    NetworkUserRepository {

    override fun getListOfUsers(id: String): Flow<Outcome<UserDto>> =
        modifyFlowOutcome(mService.getListOfUsers(id).map { it.transformUserToDto() })
}