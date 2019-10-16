package com.myozawoo.interactor

import com.myozawoo.domain.MovieRepository
import com.myozawoo.executor.BackgroundThread
import com.myozawoo.executor.PostExecutionThread
import com.myozawoo.viewstate.MovieListViewState
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

class MovieListInteractor(private val movieRepository: MovieRepository,
                          private val mainThread: PostExecutionThread,
                          private val backgroundThread: BackgroundThread){

    fun executePopularMovie(page: Int?): Observable<MovieListViewState>{
        return movieRepository.getPopularMovieList(null)
            .map { MovieListViewState.MovieList(it) }
            .cast(MovieListViewState::class.java)
            .onErrorReturn { MovieListViewState.Error(it) }
            .startWith(MovieListViewState.Progress)
            .subscribeOn(backgroundThread.getScheduler())
            .observeOn(mainThread.getScheduler())
    }

    fun executeSimilarMovie(intent: SimilarMovieIntent): Observable<MovieListViewState>{
        return movieRepository.getSimilarMovieList(null, intent.movieId)
            .map { MovieListViewState.MovieList(it) }
            .cast(MovieListViewState::class.java)
            .onErrorReturn { MovieListViewState.Error(it) }
            .startWith(MovieListViewState.Progress)
            .subscribeOn(backgroundThread.getScheduler())
            .observeOn(mainThread.getScheduler())
    }

    fun executeTopRatedMovie(page: Int?): Observable<MovieListViewState>{
        return movieRepository.getTopRatedMovieList(null)
            .map { MovieListViewState.MovieList(it) }
            .cast(MovieListViewState::class.java)
            .onErrorReturn { MovieListViewState.Error(it) }
            .startWith(MovieListViewState.Progress)
            .subscribeOn(backgroundThread.getScheduler())
            .observeOn(mainThread.getScheduler())
    }

    fun executeNowPlayingMovie(page: Int?): Observable<MovieListViewState>{
        return movieRepository.getNowPlayingMovieList(null)
            .map { MovieListViewState.MovieList(it) }
            .cast(MovieListViewState::class.java)
            .onErrorReturn { MovieListViewState.Error(it) }
            .startWith(MovieListViewState.Progress)
            .subscribeOn(backgroundThread.getScheduler())
            .observeOn(mainThread.getScheduler())
    }

    fun executeUpComingMovie(page: Int?): Observable<MovieListViewState>{
        return movieRepository.getUpcomingMovieList(null)
            .map { MovieListViewState.MovieList(it) }
            .cast(MovieListViewState::class.java)
            .onErrorReturn { MovieListViewState.Error(it) }
            .startWith(MovieListViewState.Progress)
            .subscribeOn(backgroundThread.getScheduler())
            .observeOn(mainThread.getScheduler())
    }

    data class SimilarMovieIntent(val page: Int?, val movieId: Int)

}