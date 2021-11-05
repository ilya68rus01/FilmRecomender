package com.example.core

import android.app.Application
import android.content.Context

interface ShowNewDeps {
    fun provideContext(): Context
    fun provideApplication(): Application
}