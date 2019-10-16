package com.myozawoo.moviedb.feature.movie.upcoming

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.RecyclerView
import com.myozawoo.model.movie.MovieTrailer
import com.myozawoo.moviedb.R
import kotlinx.android.synthetic.main.item_movie_trailer.view.*

class UpComingMovieRecyclerAdapter(): RecyclerView.Adapter<VHMovieTrailer>(){

    private val list = arrayListOf<MovieTrailer>()

    fun setList(trailers: List<MovieTrailer>){
        list.clear()
        list.addAll(trailers)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHMovieTrailer {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie_trailer, parent, false)
        return VHMovieTrailer(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: VHMovieTrailer, position: Int) {
        holder.bind(list[position])
    }
}