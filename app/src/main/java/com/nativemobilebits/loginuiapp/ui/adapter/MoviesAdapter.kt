package com.nativemobilebits.loginuiapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nativemobilebits.loginuiapp.R
import com.nativemobilebits.loginuiapp.entities.Movie
import com.nativemobilebits.loginuiapp.entities.MoviesList

class MoviesAdapter(private val movieList: MoviesList) : RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_movie_row_layout, parent,false)
        return MoviesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return movieList.movies.size
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.setupRowData(movieList.movies[position])
    }


    class MoviesViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
        val ivMovieLogo = itemView.findViewById<ImageView>(R.id.ivMovieLogo)
        val tvMovieTitle = itemView.findViewById<TextView>(R.id.tvMovieTitle)
        val tvDirector = itemView.findViewById<TextView>(R.id.tvDirector)

        fun setupRowData(movie: Movie) {

            tvMovieTitle.text = movie.title
            tvDirector.text = movie.director

            Glide
                .with(itemView)
                .load(movie.posterUrl)
                .into(ivMovieLogo)

        }

    }
}