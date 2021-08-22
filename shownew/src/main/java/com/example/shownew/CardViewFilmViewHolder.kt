package com.example.shownew

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.core.data.Film
import com.example.shownew.databinding.NewFilmsElementBinding
import com.squareup.picasso.Picasso
import java.util.*

class CardViewFilmViewHolder(
    private val binding: NewFilmsElementBinding
) : BaseViewHolder(binding.root) {

    constructor(parent: ViewGroup) : this(
        NewFilmsElementBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun bindView(film: Film) {
        binding.filmName.text = film.title
        val average = film.vote_average
        binding.rate.text = average.toString()
        when {
            average < 4f -> binding.rate.setBackgroundColor(Color.RED)
            average > 7f -> binding.rate.setBackgroundColor(binding.root.context.getColor(R.color.green2))
            (average > 5f) && (average < 7f) -> binding.rate.setBackgroundColor(
                binding.root.context.getColor(
                    R.color.green
                )
            )
            else -> binding.rate.setBackgroundColor(Color.YELLOW)
        }
        Picasso.with(binding.root.context)
            .load("https://image.tmdb.org/t/p/w500" + film.poster_path)
            .error(R.drawable.ic_no_image)
            .fit()
            .into(binding.poster)
        binding.poster.scaleType = ImageView.ScaleType.CENTER_CROP
        if (film.release_date > Date(System.currentTimeMillis()))
            binding.rate.visibility = View.GONE

    }
}