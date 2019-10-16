package com.myozawoo.viewstate

import com.myozawoo.model.movie.MovieInfo

sealed class MovieListViewState{

    class Error(val t: Throwable): MovieListViewState()

    object Progress: MovieListViewState()

    class MovieList(val movies: List<MovieInfo>): MovieListViewState()

}