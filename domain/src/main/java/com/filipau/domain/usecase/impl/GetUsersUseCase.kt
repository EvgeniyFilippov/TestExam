package com.filipau.domain.usecase.impl

import com.filipau.domain.dto.post.user.UserDto
import com.filipau.domain.outcome.Outcome
import com.filipau.domain.repository.NetworkUserRepository
import com.filipau.domain.usecase.UseCaseOutcomeFlow
import kotlinx.coroutines.flow.Flow

class GetUsersUseCase(private val networkUserRepository: NetworkUserRepository) : UseCaseOutcomeFlow<String, UserDto>() {

    override fun buildOutcomeFlow(params: String?): Flow<Outcome<UserDto>> =
        networkUserRepository.getListOfUsers(params ?: "")

    override val mIsParamsRequired: Boolean
        get() = true

}