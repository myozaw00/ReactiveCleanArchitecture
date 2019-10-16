package com.myozawoo.data.model.response

data class MovieInfoResponse(val vote_count: Int,
                             val id: Int,
                             val video: Boolean,
                             val vote_average: Double,
                             val title: String,
                             val popularity: Double,
                             val poster_path: String,
                             val original_language: String,
                             val original_title: String,
                             val genre_ids: List<String>,
                             val backdrop_path: String,
                             val adult: Boolean,
                             val overview: String,
                             val release_date: String)