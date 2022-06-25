package com.example.shownew.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.fragment.findNavController
import com.example.core.data.Film
import com.example.core.extensions.launchWhenViewStarted
import com.example.shownew.PopularFilmViewHolder
import com.example.shownew.databinding.FragmentNewFilmsBinding
import com.example.shownew.di.ShowNewComponentHolder
import com.example.shownew.di.ShowNewDependencies
import com.example.shownew.di.ViewModelFactory
import com.example.shownew.di.component.DaggerShowNewComponent
import com.example.shownew.ui.recycler.CardViewFilmViewHolder
import com.example.shownew.ui.recycler.FilmsAdapter
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class NewFilmsFragment : Fragment() {

    @Inject
    lateinit var showNewDependencies: ShowNewDependencies

    @Inject
    lateinit var providerFactory: ViewModelFactory

    private var _binding: FragmentNewFilmsBinding? = null
    private val binding get() = _binding!!

    private val viewModel: NewFilmsViewModel by viewModels { providerFactory }

    private val newFilmsAdapter = FilmsAdapter(
        { CardViewFilmViewHolder(it) },
        { filmId ->
            val request = NavDeepLinkRequest.Builder
                .fromUri("http://film.recommender/film/info/$filmId".toUri())
                .build()
            findNavController().navigate(request)
        }
    )

    private val popularFilmsAdapter = FilmsAdapter(
        { PopularFilmViewHolder(it) },
        { filmId ->
            val request = NavDeepLinkRequest.Builder
                .fromUri("http://film.recommender/film/info/$filmId".toUri())
                .build()
            findNavController().navigate(request)
        }
    )

    override fun onAttach(context: Context) {
        super.onAttach(context)
        DaggerShowNewComponent
            .factory()
            .create(ShowNewComponentHolder.getComponent())
            .inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewFilmsBinding.inflate(inflater)
        launchWhenViewStarted {
            with(viewModel) {
                newFilms.filter { it.isNotEmpty() }
                    .collect { updateUi(it) }
            }
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.noveltyGroup.newsFilmsRecycler.adapter = newFilmsAdapter
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun updateUi(films: List<Film>) =
        newFilmsAdapter.setNewFilms(films)
}