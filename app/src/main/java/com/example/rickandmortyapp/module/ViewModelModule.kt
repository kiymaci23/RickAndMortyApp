package com.example.rickandmortyapp.module

import com.example.rickandmortyapp.screen.MainActivityViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule= module {
    viewModel { MainActivityViewModel(get()) }
}
