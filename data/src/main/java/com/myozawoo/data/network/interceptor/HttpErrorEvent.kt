package com.myozawoo.data.network.interceptor

import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject

class HttpErrorEvent{

    companion object {

        private val eventSubject = PublishSubject.create<Event>()

        fun subscribe(): Observable<Event>{
            return eventSubject
        }


        fun emit(event: Event){
            eventSubject.onNext(event)
        }
    }

    class Event constructor(val message: String, val type: Type){
        fun `is`(type: Type): Boolean{
            return this.type == type
        }
    }

    enum class Type{
        UNAUTHORIZED, SERVER_ERROR, MAINTENANCE
    }
}