package com.example.nytimesapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.example.nytimesapp.R
import com.example.nytimesapp.data.Film

class FilmAdapter : RecyclerView.Adapter<FilmViewHolder>() {

    private val items = mutableListOf<Film>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_item, null)
        return FilmViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        val fileName = items[position].title ?: ""
        val imageUrl = items[position].imageUrl ?: ""
        holder.bind(fileName, imageUrl)
    }

    fun addItems(newItems: List<Film>) {
        items.addAll(newItems)
        notifyDataSetChanged()
    }
}

class FilmViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val textView = view.findViewById<TextView>(R.id.textView)
    private val imageView = view.findViewById<ImageView>(R.id.imageView)

    fun bind(filmName: String, imageUrl: String) {
        textView.text = filmName
        imageView.load(imageUrl)
    }
}