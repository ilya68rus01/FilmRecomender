package com.example.core

import android.content.Context
import com.example.core.di.ApplicationProvider

interface App {
    fun getApplicationContext(): Context
    fun getAppComponent(): ApplicationProvider
}