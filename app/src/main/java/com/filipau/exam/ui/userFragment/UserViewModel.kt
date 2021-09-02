package com.filipau.exam.ui.userFragment

import androidx.lifecycle.SavedStateHandle
import com.filipau.domain.dto.post.PostItemDto
import com.filipau.domain.outcome.Outcome
import com.filipau.domain.usecase.impl.GetPostsUseCase
import com.filipau.exam.Constants.ALL_POSTS_LIVE_DATA
import com.filipau.exam.Constants.ALL_USERS_LIVE_DATA
import com.filipau.exam.base.mvvm.BaseViewModel

class UserViewModel(
    savedStateHandle: SavedStateHandle,
//    private val mGetPostsUseCase: GetPostsUseCase

) : BaseViewModel(savedStateHandle) {

    val allUsersLiveData =
        savedStateHandle.getLiveData<Outcome<MutableList<PostItemDto>>>(
            ALL_USERS_LIVE_DATA
        )
}