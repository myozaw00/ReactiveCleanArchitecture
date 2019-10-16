package com.myozawoo.moviedb.feature.movie.list

import android.view.View
import com.bumptech.glide.Glide
import com.myozawoo.model.movie.MovieInfo
import com.myozawoo.moviedb.R
import com.myozawoo.moviedb.feature.base.BaseViewHolder
import kotlinx.android.synthetic.main.item_movie_info.view.*

class VHMovieInfo(itemView: View): BaseViewHolder(itemView){

    fun bind(info: MovieInfo){

        Glide.with(itemView.context)
            .load(info.posterPath)
            .placeholder(R.drawable.movie_placeholder)
            .into(itemView.ivPoster)
    }
}