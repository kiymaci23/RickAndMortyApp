package com.example.rickandmortyapp.module

import com.example.rickandmortyapp.data.repo.CharacterRepo
import com.example.rickandmortyapp.data.repo.CharacterRepoImpl
import org.koin.dsl.module

val repositoryModule= module {
    single { CharacterRepoImpl(get(),get()) }
}