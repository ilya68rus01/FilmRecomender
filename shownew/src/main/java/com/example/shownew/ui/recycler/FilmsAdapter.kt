package com.example.shownew.ui.recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.core.data.Film
import com.example.shownew.BaseViewHolder

class FilmsAdapter <T : BaseViewHolder>
constructor(
    private val createCallback: (parent: ViewGroup) -> T
) : RecyclerView.Adapter<T>() {
    private val newFilms = mutableListOf<Film>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): T = createCallback.invoke(parent)

    override fun onBindViewHolder(holder: T, position: Int) {
        holder.bindView(newFilms[position])
    }

    fun setNewFilms(films: List<Film>) {
        if (newFilms.isNotEmpty())
            newFilms.clear()
        newFilms.addAll(films)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = newFilms.size
}