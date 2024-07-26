package com.example.rickandmortyapp.data.repo

import android.content.Context
import com.example.rickandmortyapp.data.model.CharacterResponse
import com.example.rickandmortyapp.service.api.RickAndMortyApi
import com.example.rickandmortyapp.data.model.Character

interface CharacterRepo{
    suspend fun getCharacter(): CharacterResponse
    suspend fun getCharacterById(id: Long): Character
}

class CharacterRepoImpl(
    private val context:Context,
    private val api:RickAndMortyApi
):CharacterRepo {
    override suspend fun getCharacter(): CharacterResponse {
        return api.getCharacter()
    }
    override suspend fun getCharacterById(id: Long): Character {
        return api.getCharacterById(id)
    }
}
