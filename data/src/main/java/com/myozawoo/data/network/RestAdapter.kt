package com.myozawoo.data.network

import com.google.gson.Gson
import com.myozawoo.data.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class RestAdapter {
    companion object {

        private var retrofit: Retrofit? = null

        fun get(): Retrofit {
            if (retrofit == null) {
                synchronized(RestAdapter::class) {
                    if (retrofit == null) {
                        val httpClient = OkHttpClient.Builder()
                        httpClient.connectTimeout(10, TimeUnit.SECONDS)
                        httpClient.readTimeout(10, TimeUnit.SECONDS)
                        httpClient.writeTimeout(10, TimeUnit.SECONDS)
                        if (BuildConfig.DEBUG) {
                            val httpLogginInterceptor = HttpLoggingInterceptor()
                            httpLogginInterceptor.level = HttpLoggingInterceptor.Level.HEADERS
                            httpLogginInterceptor.level = HttpLoggingInterceptor.Level.BODY
                            httpClient.addInterceptor(httpLogginInterceptor)
                        }
                        retrofit = buildRetrofit(httpClient)
                    }

                }
            }
            return retrofit!!
        }


        private fun buildRetrofit(httpClient: OkHttpClient.Builder): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(Gson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(httpClient.build())
                .build()
        }

    }
}