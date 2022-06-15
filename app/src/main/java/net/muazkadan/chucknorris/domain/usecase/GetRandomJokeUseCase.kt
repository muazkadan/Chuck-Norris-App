package net.muazkadan.chucknorris.domain.usecase

import kotlinx.coroutines.flow.map
import net.muazkadan.chucknorris.data.base.map
import net.muazkadan.chucknorris.data.repository.JokeRepository
import net.muazkadan.chucknorris.domain.mapper.JokeMapper
import javax.inject.Inject

/**
 * @author muaz
 * Created on 6/15/2022.
 */
class GetRandomJokeUseCase @Inject constructor(
    private val repository: JokeRepository,
    private val mapper: JokeMapper
) {

    suspend operator fun invoke() = repository.getRandomJoke().map { restResult ->
        restResult.map { response ->
            mapper.map(response)
        }
    }
}
