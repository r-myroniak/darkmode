package com.example.darkmodeidp.data.base

import android.content.SharedPreferences
import androidx.lifecycle.LiveData

class SharedPreferenceLiveData<T>(
    private val sharedPrefs: SharedPreferences,
    private val key: String,
    private val getPreferenceValue: () -> T,
) : LiveData<T>(getPreferenceValue()), SharedPreferences.OnSharedPreferenceChangeListener {
    override fun onActive() {
        sharedPrefs.registerOnSharedPreferenceChangeListener(this)
        updateIfChanged()
    }

    override fun onInactive() = sharedPrefs.unregisterOnSharedPreferenceChangeListener(this)

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences?, key: String?) {
        if (key == this.key || key == null) {
            // Note that we get here on every preference write, even if the value has not changed
            updateIfChanged()
        }
    }

    /** Update the live data value, but only if the value has changed. */
    private fun updateIfChanged() = with(getPreferenceValue()) { if (value != this) value = this }
}

fun SharedPreferences.liveData(key: String, default: Int): LiveData<Int> =
    SharedPreferenceLiveData(this, key) { getInt(key, default) }

fun SharedPreferences.liveData(key: String, default: Long): LiveData<Long> =
    SharedPreferenceLiveData(this, key) { getLong(key, default) }

fun SharedPreferences.liveData(key: String, default: Boolean): LiveData<Boolean> =
    SharedPreferenceLiveData(this, key) { getBoolean(key, default) }

fun SharedPreferences.liveData(key: String, default: Float): LiveData<Float> =
    SharedPreferenceLiveData(this, key) { getFloat(key, default) }

fun SharedPreferences.liveData(key: String, default: String): LiveData<String> =
    SharedPreferenceLiveData(this, key) { getString(key, default)!! }

fun SharedPreferences.liveDataStringToBoolean(key: String, default: String): LiveData<Boolean> =
    SharedPreferenceLiveData(this, key) { !getString(key, default).isNullOrEmpty() }
