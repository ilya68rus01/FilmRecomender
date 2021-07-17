package com.example.shownew

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.core.data.Film
import com.example.shownew.databinding.NewFilmsElementBinding

class CardViewFilmViewHolder(
    private val binding: NewFilmsElementBinding
) : RecyclerView.ViewHolder(binding.root) {

    constructor(parent: ViewGroup) : this(
        NewFilmsElementBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    fun bindView(film: Film) {
        binding.filmName.text = film.title
        binding.genre.text = film.genres[0].name
        binding.rate.text = film.vote_average.toString()
    }
}