package com.myozawoo.model.movie

data class MovieInfo(val voteCount: Int,
                     val id: Int,
                     val video: Boolean,
                     val voteAverage: Double,
                     val title: String,
                     val popularity: Double,
                     val posterPath: String,
                     val originalLanguage: String,
                     val originalTitle: String,
                     val genreIds: List<String>,
                     val backdropPath: String,
                     val adult: Boolean,
                     val overview: String,
                     val releaseDate: String)