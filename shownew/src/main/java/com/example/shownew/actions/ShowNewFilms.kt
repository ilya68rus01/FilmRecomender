package com.example.shownew.actions

import android.content.Context
import com.example.core.actions.ShowNewFilmsAction
import com.example.shownew.NewFilmsFragment

class ShowNewFilms : ShowNewFilmsAction {
    override fun getNewFilmsFragment(context: Context) = NewFilmsFragment()
}