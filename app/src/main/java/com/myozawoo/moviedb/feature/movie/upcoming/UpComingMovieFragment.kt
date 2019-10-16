package com.myozawoo.moviedb.feature.movie.upcoming

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.myozawoo.exception.ApiException
import com.myozawoo.exception.NetworkException
import com.myozawoo.moviedb.R
import com.myozawoo.moviedb.feature.base.BaseFragment
import com.myozawoo.viewstate.UpComingMovieViewState
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.fragment_up_coming_movie.*
import org.koin.android.ext.android.inject
import timber.log.Timber

class UpComingMovieFragment: BaseFragment<UpComingMovieViewState, UpComingMovieView, UpComingMoviePresenter>(),
        UpComingMovieView{

    private val mPresenter: UpComingMoviePresenter by inject()
    private val upComingMovieRelay: PublishSubject<Any> = PublishSubject.create()
    private lateinit var mTrailerAdapter: UpComingMovieRecyclerAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_up_coming_movie, container, false)
    }

    override fun onStart() {
        super.onStart()
        setup()
        upComingMovieRelay.onNext("")
    }

    private fun setup(){
        mTrailerAdapter = UpComingMovieRecyclerAdapter()
        rvTrailer.setHasFixedSize(true)
        rvTrailer.isNestedScrollingEnabled = false
        rvTrailer.layoutManager = LinearLayoutManager(context)
        rvTrailer.adapter = mTrailerAdapter

        ivRefresh.setOnClickListener { upComingMovieRelay.onNext("") }
    }

    override fun createPresenter(): UpComingMoviePresenter {
        return mPresenter
    }

    override fun render(viewState: UpComingMovieViewState) {
        Timber.i(viewState.toString())
        when(viewState){
            is UpComingMovieViewState.Progress -> renderProgress()
            is UpComingMovieViewState.ComingSoonMovie -> renderComingSoonMovie(viewState)
            is UpComingMovieViewState.Error -> renderError(viewState)
        }
    }

    private fun renderError(viewState: UpComingMovieViewState.Error) {
        ivRefresh.visibility = View.VISIBLE
        dismissProgress()
        when(viewState.t) {
            is NetworkException -> showToast("Network Error!")
            is ApiException -> showToast((viewState.t as ApiException).errorMessage)
            else -> viewState.t.printStackTrace()
        }
    }

    private fun renderComingSoonMovie(viewState: UpComingMovieViewState.ComingSoonMovie) {
        mTrailerAdapter.setList(viewState.movies)
        dismissProgress()
    }

    private fun renderProgress() {
        ivRefresh.visibility = View.GONE
        progressBar.visibility = View.VISIBLE
    }

    private fun dismissProgress(){
        progressBar.visibility = View.GONE
    }

    override fun upComingMovieIntent(): Observable<Any> {
        return upComingMovieRelay
    }
}