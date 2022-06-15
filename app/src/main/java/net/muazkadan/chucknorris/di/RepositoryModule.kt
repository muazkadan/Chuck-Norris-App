package net.muazkadan.chucknorris.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import net.muazkadan.chucknorris.data.network.CNApi
import net.muazkadan.chucknorris.data.repository.JokeRepository

/**
 * @author muaz
 * Created on 6/15/2022.
 */
@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    fun provideJokeRepository(
        apiService: CNApi
    ) = JokeRepository(apiService)
}
