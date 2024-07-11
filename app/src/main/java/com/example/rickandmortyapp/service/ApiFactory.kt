package com.example.rickandmortyapp.service

import com.example.rickandmortyapp.service.api.RickAndMortyApi
import okhttp3.ConnectionPool
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiFactory {

    fun provideRetrofit(
        okHttpClient: OkHttpClient//Bu, Retrofit'in HTTP isteklerini gerçekleştirmek için kullanacağı OkHttpClient nesnesini alır.
        ): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient())
            .build()
    }

    fun provideHttpClient(): OkHttpClient {
        val okHttpClientBuilder = OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .connectionPool(ConnectionPool(256, 10, TimeUnit.MINUTES))
        return okHttpClientBuilder.build()
    }
}