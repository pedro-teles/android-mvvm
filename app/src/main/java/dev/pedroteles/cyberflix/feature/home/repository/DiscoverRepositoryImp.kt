package dev.pedroteles.cyberflix.feature.home.repository

import dev.pedroteles.cyberflix.commons.model.Movie
import dev.pedroteles.cyberflix.feature.home.repository.mapper.toMovieList
import dev.pedroteles.cyberflix.feature.home.repository.service.DiscoverService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DiscoverRepositoryImp @Inject constructor(
    private val discoverService: DiscoverService
) : DiscoverRepository {
    override suspend fun discoverMovies(apiKey: String): List<Movie> =
        withContext(Dispatchers.IO) {
            discoverService.discoverMovies(apiKey).toMovieList()
        }
}