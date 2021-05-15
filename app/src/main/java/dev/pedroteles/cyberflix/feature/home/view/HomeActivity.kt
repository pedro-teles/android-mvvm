package dev.pedroteles.cyberflix.feature.home.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import dev.pedroteles.cyberflix.R
import dev.pedroteles.cyberflix.commons.ext.observe
import dev.pedroteles.cyberflix.commons.model.Movie
import dev.pedroteles.cyberflix.feature.home.viewmodel.HomeViewModel
import dev.pedroteles.cyberflix.feature.home.viewmodel.state.HomeViewState

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        observeHomeState()
        requestHomeData()
    }

    private fun observeHomeState() {
        observe(viewModel.homeViewState) {
            when (it) {
                is HomeViewState.Loading -> println("loading")
                is HomeViewState.Success -> showMovieNames(it.movies)
                is HomeViewState.Failure -> println("failure")
            }
        }
    }

    private fun showMovieNames(movies: List<Movie>) {
        for (movie in movies) {
            println(movie.title)
        }
    }

    private fun requestHomeData() {
        viewModel.discoverMovies()
    }
}