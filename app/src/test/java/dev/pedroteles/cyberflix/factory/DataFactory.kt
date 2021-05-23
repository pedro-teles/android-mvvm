package dev.pedroteles.cyberflix.factory

import dev.pedroteles.cyberflix.commons.model.Movie

fun movieList() =
    listOf(
        Movie(
            id = 1,
            title = "Title 1",
            overview = "Overview 1",
            posterPath = "PosterPath 1",
            releaseDate = "2020-05-22"
        )
    )