package com.example.rickandmortyapp.module

import com.example.rickandmortyapp.service.api.RickAndMortyApi
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule= module {
    single { get<Retrofit>().create(RickAndMortyApi::class.java) }

}