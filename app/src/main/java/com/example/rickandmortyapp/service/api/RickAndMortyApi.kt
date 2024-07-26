package com.example.rickandmortyapp.service.api

import com.example.rickandmortyapp.data.model.CharacterResponse
import retrofit2.http.GET
import retrofit2.http.Path
import com.example.rickandmortyapp.data.model.Character


interface RickAndMortyApi {
    @GET("character")
    suspend fun getCharacter(): CharacterResponse

    @GET("character/{id}")
    suspend fun getCharacterById(@Path("id") id: Long): Character
}



