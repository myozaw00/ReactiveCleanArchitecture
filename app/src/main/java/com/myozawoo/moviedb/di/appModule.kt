package com.myozawoo.moviedb.di

import com.myozawoo.data.database.entity.RoomDbHelper
import com.myozawoo.data.executor.BackgroundThreadImpl
import com.myozawoo.data.executor.JobsExecutor
import com.myozawoo.data.utils.DateUtils
import com.myozawoo.executor.BackgroundThread
import com.myozawoo.executor.PostExecutionThread
import com.myozawoo.moviedb.executor.UiThread
import org.koin.dsl.module.module

val appModule = module {

    single { UiThread() as PostExecutionThread }

    single<BackgroundThread> { BackgroundThreadImpl(JobsExecutor()) }

    single { DateUtils() }

    single { RoomDbHelper(get()) }

}