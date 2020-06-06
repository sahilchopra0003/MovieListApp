package com.example.movielistapp.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movielistapp.R
import com.example.movielistapp.main.data.model.Movie
import kotlinx.android.synthetic.main.movie_row.view.*

class MovieAdapter : RecyclerView.Adapter<CustomViewHolder>() {

    var movies = ArrayList<Movie>()

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.movie_row, parent, false)
        return CustomViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.view.title.text = movies[position].title
        val poster = holder.view.imageView_poster
        Glide.with(poster.context)
            .load("https://image.tmdb.org/t/p/w500" + movies[position].poster_path)
            .into(poster)
    }

    fun setMovieList(movies: ArrayList<Movie>) {
        this.movies.addAll(movies)
        notifyDataSetChanged()
    }
}

class CustomViewHolder(val view: View) : RecyclerView.ViewHolder(view)