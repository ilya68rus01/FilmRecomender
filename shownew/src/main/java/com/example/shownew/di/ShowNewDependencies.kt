package com.example.shownew.di

import com.example.core.ShowNewDeps
import com.example.moduleinjector.BaseFeatureDependencies

interface ShowNewDependencies : BaseFeatureDependencies {
    val contextProvider: ShowNewDeps
}