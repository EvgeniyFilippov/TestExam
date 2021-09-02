package com.filipau.domain.repository

import com.filipau.domain.dto.post.PostItemDto
import com.filipau.domain.dto.post.user.UserDto
import com.filipau.domain.outcome.Outcome
import io.reactivex.rxjava3.core.Flowable
import kotlinx.coroutines.flow.Flow

interface NetworkUserRepository {

    fun getListOfUsers(id: String): Flow<Outcome<UserDto>>

}