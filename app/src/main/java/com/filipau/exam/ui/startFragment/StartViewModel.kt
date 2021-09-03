package com.filipau.exam.ui.startFragment

import androidx.lifecycle.SavedStateHandle
import com.filipau.domain.dto.post.PostItemDto
import com.filipau.domain.outcome.Outcome
import com.filipau.domain.usecase.impl.GetPostsUseCase
import com.filipau.exam.Constants.ALL_POSTS_LIVE_DATA
import com.filipau.exam.base.mvvm.BaseViewModel
import com.filipau.exam.base.mvvm.executeJob

class StartViewModel(
    savedStateHandle: SavedStateHandle,
    private val mGetPostsUseCase: GetPostsUseCase

) : BaseViewModel(savedStateHandle) {

    val allPostsLiveData =
        savedStateHandle.getLiveData<Outcome<MutableList<PostItemDto>>>(
            ALL_POSTS_LIVE_DATA
        )

    fun getPostsFromApi() {

        mCompositeDisposable.add(
            executeJob(
                mGetPostsUseCase.execute(), allPostsLiveData
            )
        )
    }

}