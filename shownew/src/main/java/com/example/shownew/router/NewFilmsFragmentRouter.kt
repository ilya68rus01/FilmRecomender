package com.example.shownew.router

interface NewFilmsFragmentRouter {
    fun navigateToFilmInfo(filmId: Int): NavCommand
}