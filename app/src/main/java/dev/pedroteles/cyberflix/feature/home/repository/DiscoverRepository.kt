package dev.pedroteles.cyberflix.feature.home.repository

import dev.pedroteles.cyberflix.commons.model.Movie

interface DiscoverRepository {
    suspend fun discoverMovies(apiKey: String): List<Movie>
}