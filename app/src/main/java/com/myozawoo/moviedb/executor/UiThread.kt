package com.myozawoo.moviedb.executor

import com.myozawoo.executor.PostExecutionThread
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers

class UiThread: PostExecutionThread{
    override fun getScheduler(): Scheduler = AndroidSchedulers.mainThread()
}