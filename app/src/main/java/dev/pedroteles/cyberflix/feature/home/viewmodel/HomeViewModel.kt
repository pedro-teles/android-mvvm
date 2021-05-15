package dev.pedroteles.cyberflix.feature.home.viewmodel

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.pedroteles.cyberflix.commons.ext.emit
import dev.pedroteles.cyberflix.commons.ext.safeLaunch
import dev.pedroteles.cyberflix.commons.model.DefaultError
import dev.pedroteles.cyberflix.feature.home.repository.DiscoverRepository
import dev.pedroteles.cyberflix.feature.home.viewmodel.state.HomeViewState
import javax.inject.Named

const val TAG = "HomeViewModel"

class HomeViewModel @ViewModelInject constructor(
    private val discoverRepository: DiscoverRepository,
    @Named("apiKey") private val apiKey: String
) : ViewModel() {

    private val mutableLiveDataState = MutableLiveData<HomeViewState>()
    val homeViewState: LiveData<HomeViewState> = mutableLiveDataState

    fun discoverMovies() = safeLaunch(::handleError) {
        mutableLiveDataState.emit(HomeViewState.Loading)

        val movies = discoverRepository.discoverMovies(apiKey)
        mutableLiveDataState.value = HomeViewState.Success(movies)
    }

    private fun handleError(error: DefaultError) {
        Log.e(TAG, error.errorMessage)
        mutableLiveDataState.emit(HomeViewState.Failure)
    }
}