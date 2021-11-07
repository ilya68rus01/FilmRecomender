package com.example.core

import android.app.Application
import android.content.Context

interface FilmInfoDeps {
    fun provideContext(): Context
    fun provideApplication(): Application
}