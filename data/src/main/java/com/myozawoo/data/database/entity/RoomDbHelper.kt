package com.myozawoo.data.database.entity

import android.content.Context
import androidx.room.Room
import com.myozawoo.data.database.RxDatabase
import com.myozawoo.data.database.dao.MovieTrailerDao

class RoomDbHelper constructor(private val context: Context) {

    private val moviTrailerDao: MovieTrailerDao


    init {
        val rxDatabase: RxDatabase = Room.databaseBuilder(context, RxDatabase::class.java,
            "moviedb")
            .fallbackToDestructiveMigration()
            .build()
        moviTrailerDao = rxDatabase.movieTrailerDao()

    }

    fun getMovieTrailerDao(): MovieTrailerDao = moviTrailerDao

}