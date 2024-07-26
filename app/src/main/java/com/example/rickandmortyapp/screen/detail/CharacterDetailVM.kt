package com.example.rickandmortyapp.screen.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyapp.core.BaseViewModel
import com.example.rickandmortyapp.data.repo.CharacterRepo
import kotlinx.coroutines.launch
import com.example.rickandmortyapp.data.model.Character

class CharacterDetailVM(private val repo: CharacterRepo): BaseViewModel() {
    private val _Character = MutableLiveData<Character>()

    var character by mutableStateOf<Character?>(null)
        private set

    fun fetchCharacter(id:Long){
        viewModelScope.launch {
            val fetchedCharacter = repo.getCharacterById(id)
            character = fetchedCharacter
        }
    }

}