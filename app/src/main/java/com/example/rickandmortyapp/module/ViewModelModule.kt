package com.example.rickandmortyapp.module

import com.example.rickandmortyapp.screen.MainActivityVM
import com.example.rickandmortyapp.screen.detail.CharacterDetailVM
import com.example.rickandmortyapp.screen.home.HomeVM
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainActivityVM() }
    viewModel { HomeVM(get()) }
    viewModel { CharacterDetailVM(get()) }
}
