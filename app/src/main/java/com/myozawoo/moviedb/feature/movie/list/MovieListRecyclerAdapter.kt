package com.myozawoo.moviedb.feature.movie.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.myozawoo.model.movie.MovieInfo
import com.myozawoo.moviedb.R

class MovieListRecyclerAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private val list = arrayListOf<MovieInfo>()

    fun setMovies(movies: List<MovieInfo>){
        list.clear()
        list.addAll(movies)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie_info, parent, false)
        return VHMovieInfo(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is VHMovieInfo -> holder.bind(list[position])
        }
    }
}