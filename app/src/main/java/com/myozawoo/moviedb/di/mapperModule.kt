package com.myozawoo.moviedb.di

import com.myozawoo.data.mapper.MovieMapper
import org.koin.dsl.module.module

val mapperModule = module {

    single { MovieMapper(get()) }
}