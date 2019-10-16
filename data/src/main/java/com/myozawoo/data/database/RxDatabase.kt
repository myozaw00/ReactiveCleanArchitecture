package com.myozawoo.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.myozawoo.data.database.dao.MovieTrailerDao
import com.myozawoo.data.database.entity.MovieTrailerEntity


@Database(entities = [ MovieTrailerEntity::class], version = 1)
abstract class RxDatabase: RoomDatabase(){

    abstract fun movieTrailerDao(): MovieTrailerDao

}