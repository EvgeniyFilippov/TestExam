package com.filipau.exam.di

import androidx.lifecycle.SavedStateHandle
import com.filipau.domain.usecase.impl.GetPostsUseCase
import com.filipau.exam.ui.startFragment.StartFragment
import com.filipau.exam.ui.startFragment.StartViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val postListModule = module {

  scope<StartFragment> {

      scoped { GetPostsUseCase(get()) }

      viewModel { (handle: SavedStateHandle) -> StartViewModel(handle, get()) }
  }
}