package dev.pedroteles.cyberflix.feature.home.repository.model

import com.google.gson.annotations.SerializedName

data class DiscoverResponse(
    val results: List<MovieResponse>?
)

data class MovieResponse(
    val id: Int?,
    val title: String?,
    val overview: String?,
    @SerializedName("poster_path")
    val posterPath: String?,
    @SerializedName("release_date")
    val releaseDate: String?
)