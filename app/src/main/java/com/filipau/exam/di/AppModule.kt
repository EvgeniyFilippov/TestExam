package com.filipau.exam.di

import com.filipau.data.api.RetrofitObj
import com.filipau.data.repository.NetworkPostRepositoryImpl
import com.filipau.data.repository.NetworkUserRepositoryImpl
import com.filipau.domain.repository.NetworkPostRepository
import com.filipau.domain.repository.NetworkUserRepository
import org.koin.dsl.module

val appModule = module {

    //Model level
//    single { DatabaseInfo.init(get()) }
    single { RetrofitObj.getPostApi() }
    single { RetrofitObj.getUserApi() }

    //Data level
    single<NetworkPostRepository> { NetworkPostRepositoryImpl(get()) }
    single<NetworkUserRepository> { NetworkUserRepositoryImpl(get()) }

}