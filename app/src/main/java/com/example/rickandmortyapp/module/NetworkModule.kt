package com.example.rickandmortyapp.module

import com.example.rickandmortyapp.service.ApiFactory
import org.koin.dsl.module

val networkModule= module {
    single { ApiFactory.provideHttpClient() }
    single { ApiFactory.provideRetrofit(get()) }
}