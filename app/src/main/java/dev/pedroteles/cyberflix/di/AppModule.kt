package dev.pedroteles.cyberflix.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dev.pedroteles.cyberflix.BaseApplication
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providesApplication(@ApplicationContext context: Context): BaseApplication {
        return context as BaseApplication
    }
}