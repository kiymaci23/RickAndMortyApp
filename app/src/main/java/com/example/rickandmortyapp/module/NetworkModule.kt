package com.example.rickandmortyapp.module

import com.example.rickandmortyapp.service.ApiFactory
import org.koin.dsl.module

val networkModule= module {
    single { ApiFactory.provideHttpClient() }// satır, ApiFactory sınıfının provideHttpClient fonksiyonunu çağırarak bir OkHttpClient nesnesi sağlar. OkHttpClient, HTTP isteklerini gerçekleştirmek için kullanılan bir kütüphanedir.

    single { ApiFactory.provideRetrofit(get()) }
}