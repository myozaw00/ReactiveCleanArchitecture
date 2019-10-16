package com.myozawoo.viewstate

import com.myozawoo.model.movie.MovieTrailer

sealed class UpComingMovieViewState{

    class Error(val t: Throwable): UpComingMovieViewState()

    class ComingSoonMovie(val movies: List<MovieTrailer>): UpComingMovieViewState()

    object Progress: UpComingMovieViewState()
}