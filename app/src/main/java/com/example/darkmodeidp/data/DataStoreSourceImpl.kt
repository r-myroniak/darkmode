package com.example.darkmodeidp.data

import androidx.lifecycle.LiveData
import com.example.darkmodeidp.data.base.DataStoreKeys.Companion.PREF_DARK_MODE
import com.example.darkmodeidp.data.base.DataStoreUtil
import com.example.darkmodeidp.data.base.liveData
import com.example.darkmodeidp.helper.ThemeHelper.DEFAULT

class DataStoreSourceImpl(private val prefs: DataStoreUtil) : DataStoreSource  {

    override suspend fun storeMode(mode: String) {
        prefs.setStringPreference(PREF_DARK_MODE, mode)
    }

    override suspend fun getMode(): LiveData<String> {
        return prefs.sharedPreferences.liveData(PREF_DARK_MODE, DEFAULT)
    }
}