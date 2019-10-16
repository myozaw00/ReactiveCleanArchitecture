package com.myozawoo.interactor

import com.myozawoo.domain.MovieRepository
import com.myozawoo.executor.BackgroundThread
import com.myozawoo.executor.PostExecutionThread
import com.myozawoo.viewstate.UpComingMovieViewState
import io.reactivex.Observable

class UpComingMovieInteractor(private val movieRepository: MovieRepository,
                              private val mainThread: PostExecutionThread,
                              private val backgroundThread: BackgroundThread){


    fun executeComingSoonMovie(): Observable<UpComingMovieViewState>{
        return movieRepository.getComingSoonMovieList()
            .map { UpComingMovieViewState.ComingSoonMovie(it) }
            .cast(UpComingMovieViewState::class.java)
            .onErrorReturn { UpComingMovieViewState.Error(it) }
            .startWith(UpComingMovieViewState.Progress)
            .subscribeOn(backgroundThread.getScheduler())
            .observeOn(mainThread.getScheduler())
    }
}