package com.myozawoo.data.network.service

import com.myozawoo.data.model.response.*
import com.myozawoo.data.network.URL
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieService {

    @GET(URL.NOW_PLAYING_MOVIES)
    fun getNowPlayingMovies(
        @Query("api_key") apiKey: String,
        @Query("page") page: Int?
    ): Observable<Response<NowPlayingMovieResponse>>

    @GET(URL.POPULAR_MOVIES)
    fun getPopularMovies(
        @Query("api_key") apiKey: String,
        @Query("page") page: Int?
    ): Observable<Response<PopularMovieResponse>>

    @GET(URL.SIMILAR_MOVIES)
    fun getSimilarMovies(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String,
        @Query("page") page: Int?
    ): Observable<Response<SimilarMovieResponse>>

    @GET(URL.TOP_RATED_MOVIES)
    fun getTopRatedMovies(
        @Query("api_key") apiKey: String,
        @Query("page") page: Int?
    ): Observable<Response<TopRatedMovieResponse>>

    @GET(URL.UPCOMING_MOVIES)
    fun getUpComingMovies(
        @Query("api_key") apiKey: String,
        @Query("page") page: Int?
    ): Observable<Response<UpComingMovieResponse>>


    @GET(URL.MOVIE_TRAILER)
    fun getMovieTrailer(@Path("movie_id") movieId: Int,
                        @Query("api_key") apiKey: String): Observable<Response<MovieTrailerResponse>>
}