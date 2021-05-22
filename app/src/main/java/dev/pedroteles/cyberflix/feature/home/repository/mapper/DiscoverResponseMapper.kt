package dev.pedroteles.cyberflix.feature.home.repository.mapper

import dev.pedroteles.cyberflix.commons.ext.orZero
import dev.pedroteles.cyberflix.commons.model.Movie
import dev.pedroteles.cyberflix.feature.home.repository.model.DiscoverResponse

fun DiscoverResponse.toMovieList() : List<Movie> {
    val movieList = mutableListOf<Movie>()

    this.results?.forEach {
        movieList.add(
            Movie(
               id = it.id.orZero(),
               title = it.title.orEmpty(),
               overview = it.overview.orEmpty(),
               posterPath = it.posterPath.orEmpty(),
               releaseDate = it.releaseDate.orEmpty()
            )
        )
    }

    return movieList
}