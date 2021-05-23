package dev.pedroteles.cyberflix.feature.home.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.verify
import dev.pedroteles.cyberflix.factory.movieList
import dev.pedroteles.cyberflix.feature.home.repository.DiscoverRepository
import dev.pedroteles.cyberflix.feature.home.viewmodel.state.HomeViewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentCaptor
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.times
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class HomeViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private val apiKey = "test"

    private val testDispatcher = TestCoroutineDispatcher()

    private val argumentCaptor: ArgumentCaptor<HomeViewState> = ArgumentCaptor.forClass(HomeViewState::class.java)

    @Mock
    lateinit var repository: DiscoverRepository

    @Mock
    lateinit var observer: Observer<HomeViewState>

    private lateinit var viewModel: HomeViewModel

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        viewModel = HomeViewModel(repository, apiKey)
        viewModel.homeViewState.observeForever(observer)
    }


    @Test
    fun whenRequestDiscoverSuccessShouldEmitLoadingThenSuccess() = runBlockingTest {
        // Given
        Mockito.`when`(repository.discoverMovies(apiKey)).thenReturn(movieList())

        // When
        viewModel.discoverMovies()

        // Then
        argumentCaptor.run {
            verify(observer, times(2)).onChanged(capture())
            assert(this.allValues[0] is HomeViewState.Loading)
            assert(this.allValues[1] is HomeViewState.Success)
        }
    }

    @Test
    fun whenRequestDiscoverFailsShouldEmitLoadingThenFailure() = runBlockingTest {
        // Given
        Mockito.`when`(repository.discoverMovies(apiKey)).thenThrow(RuntimeException())

        // When
        viewModel.discoverMovies()

        // Then
        argumentCaptor.run {
            verify(observer, times(2)).onChanged(capture())
            assert(this.allValues[0] is HomeViewState.Loading)
            assert(this.allValues[1] is HomeViewState.Failure)
        }
    }
}