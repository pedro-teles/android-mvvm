package dev.pedroteles.cyberflix.feature.home.repository.service

import dev.pedroteles.cyberflix.commons.const.URLs.DISCOVER
import dev.pedroteles.cyberflix.feature.home.repository.model.DiscoverResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface DiscoverService {
    @GET(DISCOVER)
    suspend fun discoverMovies(@Query("api_key") apiKey: String): DiscoverResponse
}