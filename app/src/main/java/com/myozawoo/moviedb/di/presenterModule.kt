package com.myozawoo.moviedb.di

import com.myozawoo.moviedb.feature.movie.list.MovieListPresenter
import com.myozawoo.moviedb.feature.movie.upcoming.UpComingMoviePresenter
import org.koin.dsl.module.module

val presenterModule = module {

    factory { MovieListPresenter(get()) }

    factory { UpComingMoviePresenter(get()) }
}