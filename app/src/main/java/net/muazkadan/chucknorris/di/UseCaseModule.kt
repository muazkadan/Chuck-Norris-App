package net.muazkadan.chucknorris.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import net.muazkadan.chucknorris.data.repository.JokeRepository
import net.muazkadan.chucknorris.domain.mapper.JokeMapper
import net.muazkadan.chucknorris.domain.usecase.GetRandomJokeUseCase

/**
 * @author muaz
 * Created on 6/15/2022.
 */
@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {

    @Provides
    fun provideGetRandomJokeUseCase(
        repository: JokeRepository,
        mapper: JokeMapper
    ) = GetRandomJokeUseCase(repository, mapper)
}
