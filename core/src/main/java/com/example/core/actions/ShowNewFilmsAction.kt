package com.example.core.actions

import android.content.Context
import androidx.fragment.app.Fragment

interface ShowNewFilmsAction {
    fun getNewFilmsFragment(context: Context): Fragment
}