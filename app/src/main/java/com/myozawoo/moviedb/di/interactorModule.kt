package com.myozawoo.moviedb.di

import com.myozawoo.interactor.MovieListInteractor
import com.myozawoo.interactor.UpComingMovieInteractor
import org.koin.dsl.module.module

val interactorModule = module {

    factory { MovieListInteractor(get(), get(), get()) }

    factory { UpComingMovieInteractor(get(), get(), get()) }

}