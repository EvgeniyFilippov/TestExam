package com.filipau.exam.di

import com.filipau.data.api.PostsService
import com.filipau.data.api.RetrofitCreator
import com.filipau.data.api.UsersService
import com.filipau.data.repository.database.DatabaseUserRepositoryImpl
import com.filipau.data.repository.network.NetworkPostRepositoryImpl
import com.filipau.data.repository.network.NetworkUserRepositoryImpl
import com.filipau.data.room.DatabaseInfo
import com.filipau.domain.repository.DatabaseUserRepository
import com.filipau.domain.repository.NetworkPostRepository
import com.filipau.domain.repository.NetworkUserRepository
import org.koin.dsl.module

val appModule = module {

    single { DatabaseInfo.init(get()) }

    single<NetworkPostRepository> { NetworkPostRepositoryImpl(get()) }
    single<NetworkUserRepository> { NetworkUserRepositoryImpl(get()) }
    single<DatabaseUserRepository> { DatabaseUserRepositoryImpl(get()) }

    val creator = RetrofitCreator()
    single<PostsService> { creator.createFlowableService(PostsService::class.java) }
    single<UsersService> { creator.createFlowService(UsersService::class.java) }

}