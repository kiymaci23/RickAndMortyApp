package com.example.rickandmortyapp.screen.home

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyapp.core.BaseViewModel
import com.example.rickandmortyapp.data.repo.CharacterRepo
import kotlinx.coroutines.launch

class HomeVM(private val repo: CharacterRepo) : BaseViewModel() {

    init {
        getCharacters()
    }

    private fun getCharacters() {
        viewModelScope.launch {
            val response = repo.getCharacter()
            Log.d("character response", "$response")
        }
    }
}