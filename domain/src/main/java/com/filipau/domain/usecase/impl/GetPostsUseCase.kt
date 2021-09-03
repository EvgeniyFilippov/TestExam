package com.filipau.domain.usecase.impl

import com.filipau.domain.dto.post.PostItemDto
import com.filipau.domain.repository.NetworkPostRepository
import com.filipau.domain.usecase.UseCase
import io.reactivex.rxjava3.core.Flowable

class GetPostsUseCase(private val networkPostRepository: NetworkPostRepository) :
    UseCase<Unit, MutableList<PostItemDto>>() {
    override fun buildFlowable(params: Unit?): Flowable<MutableList<PostItemDto>> =
        networkPostRepository.getListOfPosts()

    override val mIsParamsRequired: Boolean
        get() = false

}