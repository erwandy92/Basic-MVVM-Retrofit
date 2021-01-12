package com.erwandy.framework.basic_mvvm_retrofit.ui.main.view

import android.app.Application
import com.erwandy.framework.basic_mvvm_retrofit.utils.myModule
import com.erwandy.framework.basic_mvvm_retrofit.utils.repoModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application(){
    override fun onCreate() {
        super.onCreate()

        // start Koin!
        startKoin {
            // Android context
            androidContext(this@MyApplication)
            // modules
            val list = listOf(myModule, repoModule)
            modules(list)
        }
    }
}