package com.filipau.domain.usecase.impl

import com.filipau.domain.dto.post.PostItemDto
import com.filipau.domain.repository.NetworkRepository
import com.filipau.domain.usecase.UseCase
import io.reactivex.rxjava3.core.Flowable

class GetPostsUseCase(private val networkRepository: NetworkRepository) : UseCase<Unit, MutableList<PostItemDto>>() {
    override fun buildFlowable(params: Unit?): Flowable<MutableList<PostItemDto>> = networkRepository.getListOfPosts()

    override val mIsParamsRequired: Boolean
        get() = false

}