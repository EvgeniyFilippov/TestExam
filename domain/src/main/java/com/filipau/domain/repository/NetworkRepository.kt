package com.filipau.domain.repository

import com.filipau.domain.dto.post.PostItemDto
import com.filipau.domain.dto.post.user.UserDto
import io.reactivex.rxjava3.core.Flowable

interface NetworkRepository {

    fun getListOfPosts(): Flowable<MutableList<PostItemDto>>

    fun getListOfUsers(id: String): Flowable<MutableList<UserDto>>

}