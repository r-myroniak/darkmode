package com.example.darkmodeidp

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.darkmodeidp.data.DataStoreSource
import com.example.darkmodeidp.helper.ThemeHelper
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent.inject

class MainActivity : AppCompatActivity() {

    private val dataStoreSource: DataStoreSource by inject(DataStoreSource::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val light: Button = findViewById(R.id.light)
        val dark: Button = findViewById(R.id.dark)
        val default: Button = findViewById(R.id.defautl)

        light.setOnClickListener {
            lifecycleScope.launch {
                dataStoreSource.storeMode(ThemeHelper.LIGHT_MODE)
            }
        }

        dark.setOnClickListener {
            lifecycleScope.launch {
                dataStoreSource.storeMode(ThemeHelper.DARK_MODE)
            }
        }

        default.setOnClickListener {
            lifecycleScope.launch {
                dataStoreSource.storeMode(ThemeHelper.DEFAULT)
            }
        }
    }
}