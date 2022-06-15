package net.muazkadan.chucknorris.domain.usecase

import kotlinx.coroutines.flow.map
import net.muazkadan.chucknorris.data.base.map
import net.muazkadan.chucknorris.data.repository.JokeRepository
import net.muazkadan.chucknorris.domain.mapper.SearchJokesMapper
import javax.inject.Inject

/**
 * @author muaz
 * Created on 6/15/2022.
 */
class GetJokesByQueryUseCase @Inject constructor(
    private val repository: JokeRepository,
    private val mapper: SearchJokesMapper
) {

    suspend operator fun invoke(query: String) =
        repository.getJokeByQuery(query).map { restResult ->
            restResult.map { response ->
                mapper.map(response)
            }
        }
}
