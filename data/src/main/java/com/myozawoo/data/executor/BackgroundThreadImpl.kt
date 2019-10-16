package com.myozawoo.data.executor

import com.myozawoo.executor.BackgroundThread
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers

class BackgroundThreadImpl(private val jobExecutor: JobsExecutor): BackgroundThread{

    override fun getScheduler(): Scheduler = Schedulers.from(jobExecutor)
}