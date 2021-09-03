package com.filipau.domain.repository

import com.filipau.domain.dto.post.PostItemDto
import io.reactivex.rxjava3.core.Flowable

interface NetworkPostRepository {

    fun getListOfPosts(): Flowable<MutableList<PostItemDto>>

}