package dev.pedroteles.cyberflix.feature.home.viewmodel.state

import dev.pedroteles.cyberflix.commons.model.Movie

sealed class HomeViewState {

    object Loading : HomeViewState()
    data class Success(val movies: List<Movie>) : HomeViewState()
    object Failure : HomeViewState()
}