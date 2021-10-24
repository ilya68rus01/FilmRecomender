package com.example.shownew.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.core.data.Film
import com.example.shownew.databinding.FragmentNewFilmsBinding
import com.example.shownew.di.ViewModelFactory
import com.example.shownew.ui.recycler.FilmsAdapter
import javax.inject.Inject

class NewFilmsFragment : Fragment() {

    @Inject
    lateinit var providerFactory: ViewModelFactory
    private var _binding: FragmentNewFilmsBinding? = null
    private val binding get() = _binding!!
    private val viewModel: NewFilmsViewModel by viewModels { providerFactory }
    private val newFilmsAdapter = FilmsAdapter{
        CardViewFilmViewHolder(it)
    }
    private val popularFilmsAdapter = FilmsAdapter{
        PopularFilmViewHolder(it)
    }

    fun inject() {
        ShowNewComponent.Initializer
            .init((context?.applicationContext as App).getAppComponent())
            .inject(this@NewFilmsFragment)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewFilmsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        viewModel.newFilmsLiveData.observe(viewLifecycleOwner, this::updateUi)
//        viewModel.getNewFilms(1)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun updateUi(films: List<Film>) =
        newFilmsAdapter.setNewFilms(films)
}