package com.filipau.exam

import android.app.Application
import com.filipau.exam.di.appModule
import com.filipau.exam.di.postListModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext

class ExamApp: Application() {

    override fun onCreate() {
        super.onCreate()
        GlobalContext.startKoin {
            // Koin Android logger
            androidLogger()
            //inject Android context
            androidContext(this@ExamApp)
            // use modules
            modules(
                appModule,
                postListModule
            )
        }

    }
}