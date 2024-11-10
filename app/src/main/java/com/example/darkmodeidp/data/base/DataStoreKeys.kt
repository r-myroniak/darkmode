package com.example.darkmodeidp.data.base

import androidx.annotation.StringDef
import com.example.darkmodeidp.data.base.DataStoreKeys.Companion.PREF_DARK_MODE

@StringDef(
    PREF_DARK_MODE
)
@Retention(AnnotationRetention.SOURCE)
annotation class DataStoreKeys {

    companion object {
        const val PREF_DARK_MODE = "mode"
    }
}