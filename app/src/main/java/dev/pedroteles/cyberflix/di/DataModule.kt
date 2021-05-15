package dev.pedroteles.cyberflix.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dev.pedroteles.cyberflix.feature.home.repository.DiscoverRepository
import dev.pedroteles.cyberflix.feature.home.repository.DiscoverRepositoryImp
import dev.pedroteles.cyberflix.feature.home.repository.service.DiscoverService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object DataModule {

    @Singleton
    @Provides
    @Named("apiKey")
    fun provideApiKey(): String = "7ddb6247b90b09e601cc4c905b51888d"

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Singleton
    @Provides
    fun provideDiscoverService(retrofit: Retrofit): DiscoverService =
        retrofit.create(DiscoverService::class.java)

    @Singleton
    @Provides
    fun provideDiscoverRepository(discoverService: DiscoverService): DiscoverRepository =
        DiscoverRepositoryImp(discoverService)
}