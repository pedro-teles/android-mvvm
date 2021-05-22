package dev.pedroteles.cyberflix.commons.model

data class Movie(
    val id: Int,
    val title: String,
    val overview: String,
    val posterPath: String,
    val releaseDate: String
)