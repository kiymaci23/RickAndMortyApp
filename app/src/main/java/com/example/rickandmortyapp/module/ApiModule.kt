package com.example.rickandmortyapp.module

import com.example.rickandmortyapp.service.api.RickAndMortyApi
import org.koin.dsl.module

val apiModule= module {//koin bağımlılık enjeksiyon kütüphanesini kullanarak bir modül tanımlar.
    single { RickAndMortyApi::class.java }
}