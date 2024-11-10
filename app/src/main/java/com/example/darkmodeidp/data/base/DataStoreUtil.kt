package com.example.darkmodeidp.data.base

import android.content.Context
import android.content.SharedPreferences

const val APP_PREFERENCES = "app_pref"

class DataStoreUtil(context: Context) : BaseDataStoreUtil() {

    override val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE)
}