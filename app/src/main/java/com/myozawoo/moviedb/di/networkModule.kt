package com.myozawoo.moviedb.di

import com.myozawoo.data.datasource.remote.NetworkMovieDataSource
import org.koin.dsl.module.module

val networkModule = module {

    single { NetworkMovieDataSource() }
}