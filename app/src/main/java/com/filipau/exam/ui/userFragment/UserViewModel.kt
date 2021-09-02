package com.filipau.exam.ui.userFragment

import androidx.lifecycle.SavedStateHandle
import com.filipau.domain.dto.post.user.UserDto
import com.filipau.domain.outcome.Outcome
import com.filipau.domain.usecase.impl.GetUsersUseCase
import com.filipau.exam.base.mvvm.BaseViewModel
import kotlinx.coroutines.flow.Flow

class UserViewModel(
    savedStateHandle: SavedStateHandle,
    private val mGetUsersUseCase: GetUsersUseCase

) : BaseViewModel(savedStateHandle) {

    fun getNewsFlow(id: String): Flow<Outcome<MutableList<UserDto>>> =
        mGetUsersUseCase.setParams(id).execute()

}