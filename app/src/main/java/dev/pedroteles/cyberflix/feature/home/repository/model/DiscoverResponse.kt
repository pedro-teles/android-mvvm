package dev.pedroteles.cyberflix.feature.home.repository.model

import dev.pedroteles.cyberflix.commons.model.Movie

data class DiscoverResponse(
    val results: List<Movie>
)