package com.myozawoo.moviedb.feature.movie.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.myozawoo.exception.ApiException
import com.myozawoo.exception.NetworkException
import com.myozawoo.interactor.MovieListInteractor
import com.myozawoo.model.movie.MovieType
import com.myozawoo.moviedb.R
import com.myozawoo.moviedb.feature.base.BaseFragment
import com.myozawoo.viewstate.MovieListViewState
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.fragment_movie_list.*
import org.koin.android.ext.android.inject
import timber.log.Timber

class MovieListFragment: BaseFragment<MovieListViewState, MovieListView, MovieListPresenter>(),
    MovieListView {

    private val mPresenter: MovieListPresenter by inject()
    private val nowPlayingMovieRelay: PublishSubject<Int> = PublishSubject.create()
    private val popularMovieRelay: PublishSubject<Int> = PublishSubject.create()
    private val similarMovieRelay: PublishSubject<MovieListInteractor.SimilarMovieIntent> = PublishSubject.create()
    private val topRatedMovieRelay: PublishSubject<Int> = PublishSubject.create()
    private val upComingMovieRelay: PublishSubject<Int> = PublishSubject.create()
    private lateinit var mMovieType: MovieType
    private var mMovieId: Int = 0
    private lateinit var mMovieAdapter: MovieListRecyclerAdapter

    companion object {
        fun newInstance(type: MovieType): MovieListFragment {
            val fragment = MovieListFragment()
            fragment.mMovieType = type
            return fragment
        }

        fun newInstance(type: MovieType, movieId: Int): MovieListFragment {
            val fragment = MovieListFragment()
            fragment.mMovieType = type
            fragment.mMovieId = movieId
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_movie_list, container, false)
        return view
    }

    override fun onStart() {
        super.onStart()
        setup()
        fetchMovieList()

    }


    private fun setup(){
        mMovieAdapter = MovieListRecyclerAdapter()
        rvMovie.setHasFixedSize(true)
        rvMovie.isNestedScrollingEnabled = false
        rvMovie.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rvMovie.adapter = mMovieAdapter

        ivRefresh.setOnClickListener {
            fetchMovieList()
        }
    }

    override fun createPresenter(): MovieListPresenter {
        return mPresenter
    }

    override fun render(viewState: MovieListViewState) {
        when(viewState){
            is MovieListViewState.Progress -> renderProgress()
            is MovieListViewState.MovieList -> renderMovieList(viewState)
            is MovieListViewState.Error -> renderError(viewState)
        }
    }

    private fun renderError(viewState: MovieListViewState.Error) {
        dismissProgress()
        ivRefresh.visibility = View.VISIBLE
        when(viewState.t) {
            is NetworkException -> showToast("Network Error!")
            is ApiException -> showToast((viewState.t as ApiException).errorMessage)
            else -> viewState.t.printStackTrace()
        }
    }

    private fun renderMovieList(viewState: MovieListViewState.MovieList) {
        dismissProgress()
        mMovieAdapter.setMovies(viewState.movies)
    }

    private fun renderProgress() {
        ivRefresh.visibility = View.GONE
        progressBar.visibility = View.VISIBLE
    }

    private fun dismissProgress(){
        progressBar.visibility = View.GONE
    }

    override fun popularMovieListIntent(): Observable<Int> {
        return popularMovieRelay
    }

    override fun nowPlayingMovieListIntent(): Observable<Int> {
        return nowPlayingMovieRelay
    }

    override fun similarMovieListIntent(): Observable<MovieListInteractor.SimilarMovieIntent> {
        return similarMovieRelay
    }

    override fun topRatedMovieListIntent(): Observable<Int> {
        return topRatedMovieRelay
    }

    override fun upComingMovieListIntent(): Observable<Int> {
        return upComingMovieRelay
    }

    private fun fetchMovieList(){
        when(mMovieType){
            MovieType.NOW_PLAYING_MOVIE -> {
                tvTitle.text = getString(R.string.now_showing)
                nowPlayingMovieRelay.onNext(1)
            }
            MovieType.POPULAR_MOVIE -> {
                tvTitle.text = getString(R.string.popular)
                popularMovieRelay.onNext(1)
            }
            MovieType.TOP_RATED_MOVIE -> {
                tvTitle.text = getString(R.string.top_rated)
                topRatedMovieRelay.onNext(1)
            }
            MovieType.SIMILAR_MOVIE -> {
                similarMovieRelay.onNext(MovieListInteractor.SimilarMovieIntent(1, mMovieId))
            }

            MovieType.UPCOMING_MOVIE -> {
                tvTitle.text = getString(R.string.upcoming_movie)
                upComingMovieRelay.onNext(1)
            }
        }
    }
}