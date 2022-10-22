package com.example.feature.film_info.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.core.basefragment.BaseBindingFragment
import com.example.core.extensions.launchWhenViewStarted
import com.example.feature.film_info.FilmInfo
import com.example.feature.film_info.databinding.FragmentFilmInfoBinding
import com.example.feature.film_info.di.FilmInfoComponentHolder
import com.example.feature.film_info.di.FilmInfoDependencies
import com.example.feature.film_info.di.component.DaggerFilmInfoComponent
import javax.inject.Inject

class FilmInfoFragment : BaseBindingFragment<FragmentFilmInfoBinding>(FragmentFilmInfoBinding::inflate) {

    @Inject
    lateinit var filmInfoDependencies: FilmInfoDependencies

    @Inject
    lateinit var viewModel: FilmInfoViewModel

    //region Lifecycle

    override fun onAttach(context: Context) {
        super.onAttach(context)
        DaggerFilmInfoComponent.factory()
            .create(FilmInfoComponentHolder.getComponent())
            .inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.getString("id")?.let {
            viewModel.initByBundle(it.toInt())
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        launchWhenViewStarted {
            with(viewModel) {
                filmInfo.observe {
                    updateUi(it)
                }
            }
        }
    }

    //endregion

    private fun updateUi(filmInfo: FilmInfo) {
        Log.d("Mylogs",filmInfo.toString())
    }
}