package com.myozawoo.moviedb.feature.movie.upcoming

import com.hannesdorfmann.mosby3.mvi.MviBasePresenter
import com.myozawoo.interactor.UpComingMovieInteractor
import com.myozawoo.viewstate.UpComingMovieViewState
import io.reactivex.Observable

class UpComingMoviePresenter(private val upComingMovieInteractor: UpComingMovieInteractor)
    : MviBasePresenter<UpComingMovieView, UpComingMovieViewState>(){

    override fun bindIntents() {
        val upComingMovieIntent: Observable<UpComingMovieViewState> = intent(UpComingMovieView::upComingMovieIntent)
            .flatMap { upComingMovieInteractor.executeComingSoonMovie()}

        subscribeViewState(upComingMovieIntent, UpComingMovieView::render)
    }
}