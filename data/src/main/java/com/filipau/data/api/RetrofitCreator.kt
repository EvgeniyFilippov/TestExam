package com.filipau.data.api

import com.chenxyu.retrofit.adapter.FlowCallAdapterFactory
import com.filipau.data.NetConstants.BASE_URL
import com.filipau.data.NetConstants.SESSION_TIMEOUT
import com.google.gson.Gson
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitCreator {

    private fun createOkHttpClient(): OkHttpClient {
        val httpLoginInterceptor = HttpLoggingInterceptor()
        httpLoginInterceptor.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder()
            .connectTimeout(SESSION_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(SESSION_TIMEOUT, TimeUnit.SECONDS)
            .addInterceptor(httpLoginInterceptor)
            .build()
    }

    fun <ServiceClass> createFlowableService(
        serviceClass: Class<ServiceClass>
    ): ServiceClass {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .client(createOkHttpClient())
            .build()
        return retrofit.create(serviceClass)
    }

    fun <ServiceClass> createFlowService(
        serviceClass: Class<ServiceClass>
    ): ServiceClass {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(FlowCallAdapterFactory())
            .client(createOkHttpClient())
            .build()
        return retrofit.create(serviceClass)
    }

}