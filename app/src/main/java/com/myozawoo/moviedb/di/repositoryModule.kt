package com.myozawoo.moviedb.di

import com.myozawoo.data.repository.MovieRepositoryImpl
import com.myozawoo.domain.MovieRepository
import org.koin.dsl.module.module

val repositoryModule = module {

    single<MovieRepository> { MovieRepositoryImpl(get(), get(), get()) }

}