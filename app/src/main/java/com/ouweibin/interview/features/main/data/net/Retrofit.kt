package com.ouweibin.interview.features.main.data.net

import com.ouweibin.interview.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Retrofit {
    companion object {
        private val INSTANT by lazy {
            Retrofit.Builder()
                    .baseUrl("http://www.baidu.com")
                    .client(createClient())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
        }

        fun get() = INSTANT
        private fun createClient(): OkHttpClient{
            val okHttpClientBuilder: OkHttpClient.Builder = OkHttpClient.Builder()
            if (BuildConfig.DEBUG) {
                val loggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC)
                okHttpClientBuilder.addInterceptor(loggingInterceptor)
            }
            return okHttpClientBuilder.build()
        }
    }
}