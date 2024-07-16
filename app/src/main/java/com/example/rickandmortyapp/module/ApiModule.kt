package com.example.rickandmortyapp.module

import com.example.rickandmortyapp.service.api.RickAndMortyApi
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule= module {//koin bağımlılık enjeksiyon kütüphanesini kullanarak bir modül tanımlar.
    single { get<Retrofit>().create(RickAndMortyApi::class.java) }

}