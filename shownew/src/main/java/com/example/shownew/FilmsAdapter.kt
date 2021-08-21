package com.example.shownew

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.core.data.Film

class FilmsAdapter : RecyclerView.Adapter<CardViewFilmViewHolder>() {
    private val newFilms = mutableListOf<Film>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CardViewFilmViewHolder {
        return CardViewFilmViewHolder(parent)
    }

    override fun onBindViewHolder(holder: CardViewFilmViewHolder, position: Int) {
        holder.bindView(newFilms[position])
    }

    fun setNewFilms(films: List<Film>) {
        if (newFilms.isNotEmpty())
            newFilms.clear()
        newFilms.addAll(films)
        this.notifyDataSetChanged()
    }

    override fun getItemCount(): Int = newFilms.size
}