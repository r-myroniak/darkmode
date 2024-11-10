package com.example.darkmodeidp.data.base

import android.content.SharedPreferences

abstract class BaseDataStoreUtil {

    abstract val sharedPreferences: SharedPreferences

    fun getIntegerPreference(@DataStoreKeys key: String, defaultValue: Int): Int {
        return sharedPreferences.getInt(key, defaultValue)
    }

    fun setIntegerPreference(@DataStoreKeys key: String, value: Int) {
        sharedPreferences.edit().putInt(key, value).apply()
    }

    fun getLongPreference(@DataStoreKeys key: String, defaultValue: Long): Long {
        return sharedPreferences.getLong(key, defaultValue)
    }

    fun setLongPreference(@DataStoreKeys key: String, value: Long) {
        sharedPreferences.edit().putLong(key, value).apply()
    }

    fun getBooleanPreference(@DataStoreKeys key: String, defaultValue: Boolean): Boolean {
        return sharedPreferences.getBoolean(key, defaultValue)
    }

    fun setBooleanPreference(@DataStoreKeys key: String, value: Boolean) {
        sharedPreferences.edit().putBoolean(key, value).apply()
    }

    fun getStringPreference(@DataStoreKeys key: String, defaultValue: String? = null): String? {
        return sharedPreferences.getString(key, defaultValue)
    }

    fun setStringPreference(@DataStoreKeys key: String, value: String?) {
        sharedPreferences.edit().putString(key, value).apply()
    }

    fun getStringSetPreference(
        @DataStoreKeys key: String, defaultValue: Set<String>?
    ): Set<String>? {
        return sharedPreferences.getStringSet(key, defaultValue)
    }

    fun setStringSetPreference(@DataStoreKeys key: String, value: Set<String>) {
        sharedPreferences.edit().putStringSet(key, value).apply()
    }

    fun remove(@DataStoreKeys key: String) {
        sharedPreferences.edit().remove(key).apply()
    }

    fun wipePreferences() {
        sharedPreferences.edit().clear().apply()
    }
}