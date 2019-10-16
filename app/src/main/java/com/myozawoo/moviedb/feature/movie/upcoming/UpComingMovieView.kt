package com.myozawoo.moviedb.feature.movie.upcoming

import com.hannesdorfmann.mosby3.mvp.MvpView
import com.myozawoo.viewstate.UpComingMovieViewState
import io.reactivex.Observable

interface UpComingMovieView: MvpView{

    fun render(viewState: UpComingMovieViewState)

    fun upComingMovieIntent(): Observable<Any>
}