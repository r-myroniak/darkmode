package com.example.darkmodeidp.di

import com.example.darkmodeidp.data.DataStoreSource
import com.example.darkmodeidp.data.DataStoreSourceImpl
import com.example.darkmodeidp.data.base.DataStoreUtil
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val preferencesModule = module {
    single<DataStoreSource> { DataStoreSourceImpl(DataStoreUtil(androidApplication())) }
}