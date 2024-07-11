package com.example.rickandmortyapp.data.repo

import android.content.Context
import com.example.rickandmortyapp.data.model.CharacterResponse
import com.example.rickandmortyapp.service.api.RickAndMortyApi

interface CharacterRepo{
    suspend fun getCharacter():CharacterResponse//karakter verilerini almak için bir fonksiyon
}
class CharacterRepoImpl(
    private val context:Context,//Android bağlamı.
    private val api:RickAndMortyApi//API servisi.
):CharacterRepo {
    override suspend fun getCharacter(): CharacterResponse {
        TODO("Not yet implemented")
    }
}