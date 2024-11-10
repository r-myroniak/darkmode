package com.example.darkmodeidp

import android.app.Application
import com.example.darkmodeidp.data.DataStoreSource
import com.example.darkmodeidp.di.appComponent
import com.example.darkmodeidp.helper.ThemeHelper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin
import org.koin.java.KoinJavaComponent.inject

class MyApplication : Application() {

    private val dataStoreSource: DataStoreSource by inject(DataStoreSource::class.java)
    private val applicationScope = CoroutineScope(SupervisorJob() + Dispatchers.Main)

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(appComponent)
        }

        initTheme()
    }

    private fun initTheme() {
        applicationScope.launch {
            dataStoreSource.getMode().observeForever {
                ThemeHelper.applyTheme(it)
            }
        }
    }
}