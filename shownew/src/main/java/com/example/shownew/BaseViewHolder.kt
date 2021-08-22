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

abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bindView(film: Film)
}