package com.myozawoo.executor

import io.reactivex.Scheduler

interface BackgroundThread{

    fun getScheduler(): Scheduler

}