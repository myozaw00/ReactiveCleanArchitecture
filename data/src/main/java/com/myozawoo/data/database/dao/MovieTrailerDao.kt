package com.myozawoo.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.myozawoo.data.database.entity.MovieTrailerEntity
import io.reactivex.Observable
import io.reactivex.Single


@Dao
interface MovieTrailerDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovieTrailers(entities: List<MovieTrailerEntity>): List<Long>

    @Query("SELECT * FROM movie_trailer")
    fun getAllMovieTrailers(): Single<List<MovieTrailerEntity>>
}
