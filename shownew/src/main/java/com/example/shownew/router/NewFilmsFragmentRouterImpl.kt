package com.example.shownew.router

import androidx.core.net.toUri
import androidx.navigation.NavDeepLinkRequest

class NewFilmsFragmentRouterImpl : NewFilmsFragmentRouter {

    override fun navigateToFilmInfo(filmId: Int) =
        NavCommand(
            NavDeepLinkRequest.Builder
                .fromUri("http://film.recommender/film/info/$filmId".toUri())
                .build()
        )
}
