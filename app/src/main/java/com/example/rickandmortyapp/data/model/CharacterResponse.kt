package com.example.rickandmortyapp.data.model

data class CharacterResponse (
    val info: Info,
    val results: List<Character>
)


data class Info (
    val count: Long,
    val pages: Long,
    val next: String,
    val prev: Any? = null
)

data class Character (
    val id: Long,
    val name: String,
    val status: Status,
    val species: Species,
    val type: String,
    val gender: Gender,
    val origin: Location,
    val location: Location,
    val image: String,
    val episode: List<String>,
    val url: String,
    val created: String
)

enum class Gender {
    Female,
    Male,
    Unknown
}

data class Location (
    val name: String,
    val url: String
)

enum class Species {
    Alien,
    Human
}

enum class Status {
    Alive,
    Dead,
    Unknown
}
