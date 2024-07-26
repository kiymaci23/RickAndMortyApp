package com.example.rickandmortyapp.core

import android.app.Application
import com.example.rickandmortyapp.module.apiModule
import com.example.rickandmortyapp.module.networkModule
import com.example.rickandmortyapp.module.repositoryModule
import com.example.rickandmortyapp.module.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class RickAndMortyApplication : Application() {
    private val koinModules= listOf(apiModule, networkModule, repositoryModule, viewModelModule)
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }
    private fun initKoin(){
        startKoin{
            androidContext(this@RickAndMortyApplication)
            koin.loadModules(koinModules)
        }

    }

}