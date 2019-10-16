package com.myozawoo.moviedb.feature.movie.list

import com.hannesdorfmann.mosby3.mvp.MvpView
import com.myozawoo.interactor.MovieListInteractor
import com.myozawoo.viewstate.MovieListViewState
import io.reactivex.Observable

interface MovieListView: MvpView{

    fun render(viewState: MovieListViewState)

    fun popularMovieListIntent(): Observable<Int>

    fun nowPlayingMovieListIntent(): Observable<Int>

    fun similarMovieListIntent(): Observable<MovieListInteractor.SimilarMovieIntent>

    fun topRatedMovieListIntent(): Observable<Int>

    fun upComingMovieListIntent(): Observable<Int>
}