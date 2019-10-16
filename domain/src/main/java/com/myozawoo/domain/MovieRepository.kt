package com.myozawoo.domain

import com.myozawoo.model.movie.MovieInfo
import com.myozawoo.model.movie.MovieTrailer
import io.reactivex.Observable

interface MovieRepository{

    fun getPopularMovieList(page: Int?): Observable<List<MovieInfo>>

    fun getSimilarMovieList(page: Int?,  movieId: Int): Observable<List<MovieInfo>>

    fun getTopRatedMovieList(page: Int?): Observable<List<MovieInfo>>

    fun getNowPlayingMovieList(page: Int?): Observable<List<MovieInfo>>

    fun getUpcomingMovieList(page: Int?): Observable<List<MovieInfo>>

    fun getComingSoonMovieList(): Observable<List<MovieTrailer>>

}