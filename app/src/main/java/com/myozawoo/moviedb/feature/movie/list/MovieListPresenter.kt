package com.myozawoo.moviedb.feature.movie.list

import com.hannesdorfmann.mosby3.mvi.MviBasePresenter
import com.myozawoo.interactor.MovieListInteractor
import com.myozawoo.viewstate.MovieListViewState
import io.reactivex.Observable

class MovieListPresenter(private val interactor: MovieListInteractor)
    :MviBasePresenter<MovieListView, MovieListViewState>(){

    override fun bindIntents() {
        val nowPlayingMovieIntent: Observable<MovieListViewState> = intent(MovieListView::nowPlayingMovieListIntent)
            .flatMap { interactor.executeNowPlayingMovie(it) }

        val popularMovieIntent: Observable<MovieListViewState> = intent(MovieListView::popularMovieListIntent)
            .flatMap { interactor.executePopularMovie(it) }

        val similarMovieIntent: Observable<MovieListViewState> = intent(MovieListView::similarMovieListIntent)
            .flatMap { interactor.executeSimilarMovie(it) }

        val topRatedMovieIntent: Observable<MovieListViewState> = intent(MovieListView::topRatedMovieListIntent)
            .flatMap { interactor.executeTopRatedMovie(it) }

        val upComingMovieIntent: Observable<MovieListViewState> = intent(MovieListView::upComingMovieListIntent)
            .flatMap {  interactor.executeUpComingMovie(it) }

        val allIntents = Observable.mergeArray(nowPlayingMovieIntent,
            popularMovieIntent,
            similarMovieIntent,
            topRatedMovieIntent,
            upComingMovieIntent)

        subscribeViewState(allIntents, MovieListView::render)
    }
}