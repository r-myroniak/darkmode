package com.example.darkmodeidp.data

import androidx.lifecycle.LiveData

interface DataStoreSource {
    suspend fun storeMode(mode: String)
    suspend fun getMode(): LiveData<String>
}