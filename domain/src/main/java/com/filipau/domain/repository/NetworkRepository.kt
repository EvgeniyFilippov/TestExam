package com.filipau.domain.repository

import com.filipau.domain.dto.UserItemDto
import com.filipau.domain.dto.post.PostItemDto
import io.reactivex.rxjava3.core.Flowable

interface NetworkRepository {

    fun getListOfPosts(): Flowable<MutableList<PostItemDto>>

    fun getListOfUsers(id: String): Flowable<MutableList<UserItemDto>>

}