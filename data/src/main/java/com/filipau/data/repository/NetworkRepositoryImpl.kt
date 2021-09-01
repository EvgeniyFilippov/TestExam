package com.filipau.data.repository

import com.filipau.data.api.PostsAndUsersService
import com.filipau.data.ext.transformPostToDto
import com.filipau.domain.dto.UserItemDto
import com.filipau.domain.dto.post.PostItemDto
import com.filipau.domain.repository.NetworkRepository
import io.reactivex.rxjava3.core.Flowable

class NetworkRepositoryImpl(private val mService: PostsAndUsersService) :
    NetworkRepository {

    override fun getListOfPosts(): Flowable<MutableList<PostItemDto>> =
        mService.getListOfPosts().map { it.transformPostToDto() }

    override fun getListOfUsers(id: String): Flowable<MutableList<UserItemDto>> {
        TODO("Not yet implemented")
    }
}