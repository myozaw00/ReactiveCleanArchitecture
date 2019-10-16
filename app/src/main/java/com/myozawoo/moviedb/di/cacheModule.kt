package com.myozawoo.moviedb.di

import com.myozawoo.data.datasource.cache.CacheMovieDataSource
import org.koin.dsl.module.module

val cacheModule = module {

    single { CacheMovieDataSource(get()) }

}