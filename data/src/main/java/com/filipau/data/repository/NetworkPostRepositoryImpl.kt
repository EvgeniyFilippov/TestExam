package com.filipau.data.repository

import com.filipau.data.api.PostsService
import com.filipau.data.ext.transformPostToDto
import com.filipau.domain.dto.post.PostItemDto
import com.filipau.domain.dto.post.user.UserDto
import com.filipau.domain.repository.NetworkPostRepository
import io.reactivex.rxjava3.core.Flowable
import kotlinx.coroutines.flow.Flow

class NetworkPostRepositoryImpl(private val mService: PostsService) :
    NetworkPostRepository {

    override fun getListOfPosts(): Flowable<MutableList<PostItemDto>> =
        mService.getListOfPosts()
            .map { it.transformPostToDto() }

}