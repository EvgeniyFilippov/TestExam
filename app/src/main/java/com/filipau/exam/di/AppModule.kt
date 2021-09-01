package com.filipau.exam.di

import com.filipau.data.api.RetrofitObj
import com.filipau.data.repository.NetworkRepositoryImpl
import com.filipau.domain.repository.NetworkRepository
import org.koin.dsl.module

val appModule = module {

    //Model level
//    single { DatabaseInfo.init(get()) }
    single { RetrofitObj.getPostApi() }

    //Data level
    single<NetworkRepository> { NetworkRepositoryImpl(get()) }

}