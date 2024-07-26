package com.example.rickandmortyapp.screen.home

import android.util.Log
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyapp.core.BaseViewModel
import com.example.rickandmortyapp.data.model.Character
import com.example.rickandmortyapp.data.repo.CharacterRepo
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

class HomeVM(private val repo: CharacterRepo) : BaseViewModel() {
    var characterList by mutableStateOf(emptyList<Character>())
    var errorMessage by mutableStateOf("")
    var filteredCharacterList by mutableStateOf(emptyList<Character>())

    init {
        getCharacters()
    }

    private fun getCharacters() {
        viewModelScope.launch {
            try {
                val response = repo.getCharacter()
                characterList = response.results
                errorMessage = ""
                Log.d("character response", "$response")
            } catch (e: Exception) {
                errorMessage = "Failed to load characters"
                Log.e("character response", "Error loading characters", e)
            }
        }
    }
    fun filterCharacters(query: String) {
        Log.d("filterCharacters", "Query: $query")
        filteredCharacterList = if (query.isEmpty()) {
            characterList
        } else {
            characterList.filter { it.name.contains(query, ignoreCase = true) }
        }
        Log.d("filterCharacters", "Filtered List: ${filteredCharacterList.size}")
    }
}
