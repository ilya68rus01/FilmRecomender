package com.example.feature.film_info.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.feature.film_info.databinding.FragmentFilmInfoBinding
import com.example.feature.film_info.di.FilmInfoComponentHolder
import com.example.feature.film_info.di.FilmInfoDependencies
import com.example.feature.film_info.di.component.DaggerFilmInfoComponent
import javax.inject.Inject

class FilmInfoFragment : Fragment() {

    private var _binding: FragmentFilmInfoBinding? = null
    private val binding
        get() = _binding ?: throw IllegalArgumentException("Binding not initialized")

    @Inject
    lateinit var filmInfoDependencies: FilmInfoDependencies

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerFilmInfoComponent.factory()
            .create(FilmInfoComponentHolder.getComponent())
            .inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFilmInfoBinding.inflate(inflater)
        return binding.root
    }

}