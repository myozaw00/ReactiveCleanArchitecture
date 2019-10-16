package com.myozawoo.moviedb.feature.movie.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.myozawoo.model.movie.MovieType
import com.myozawoo.moviedb.R

class MovieListContainerFragment: Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_movie_list_container, container, false)
    }

    override fun onStart() {
        super.onStart()
        setup()
    }

    private fun setup() {

        val upComingFragment = MovieListFragment.newInstance(MovieType.UPCOMING_MOVIE)
        val transactionFour = childFragmentManager.beginTransaction()
        transactionFour.replace(R.id.upComingContainer, upComingFragment)
        transactionFour.commit()

        val nowShowingMovieFragment = MovieListFragment.newInstance(MovieType.NOW_PLAYING_MOVIE)
        val transactionTwo = childFragmentManager.beginTransaction()
        transactionTwo.replace(R.id.nowShowingContainer, nowShowingMovieFragment)
        transactionTwo.commit()

        val popularMovieFragment = MovieListFragment.newInstance(MovieType.POPULAR_MOVIE)
        val transactionThree = childFragmentManager.beginTransaction()
        transactionThree.replace(R.id.popularContainer, popularMovieFragment)
        transactionThree.commit()

        val topRatedMovieListFragment = MovieListFragment.newInstance(MovieType.TOP_RATED_MOVIE)
        val transactionOne = childFragmentManager.beginTransaction()
        transactionOne.replace(R.id.topRatedContainer, topRatedMovieListFragment)
        transactionOne.commit()
    }
}