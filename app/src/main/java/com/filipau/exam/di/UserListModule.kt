package com.filipau.exam.di

import androidx.lifecycle.SavedStateHandle
import com.filipau.domain.usecase.impl.GetUsersUseCase
import com.filipau.exam.ui.userFragment.UserFragment
import com.filipau.exam.ui.userFragment.UserViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val userListModule = module {

    scope<UserFragment> {

        scoped { GetUsersUseCase(get()) }

        viewModel { (handle: SavedStateHandle) -> UserViewModel(handle, get(), get()) }
    }
}