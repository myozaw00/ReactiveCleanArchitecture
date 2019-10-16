package com.myozawoo.model.movie

data class MovieTrailer(val id: Int,
                        val title: String,
                        val overview: String,
                        val youtubeId: String,
                        val releaseDate: String,
                        val poster: String,
                        val originalPoster: String)