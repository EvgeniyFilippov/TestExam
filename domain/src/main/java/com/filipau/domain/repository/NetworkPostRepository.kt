package com.filipau.domain.repository

import com.filipau.domain.dto.post.PostItemDto
import com.filipau.domain.dto.post.user.UserDto
import io.reactivex.rxjava3.core.Flowable
import kotlinx.coroutines.flow.Flow

interface NetworkPostRepository {

    fun getListOfPosts(): Flowable<MutableList<PostItemDto>>

}