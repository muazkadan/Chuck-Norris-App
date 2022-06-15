package net.muazkadan.chucknorris.domain.mapper

import net.muazkadan.chucknorris.data.model.response.SearchJokeResponse
import net.muazkadan.chucknorris.domain.uimodel.JokeUIModel
import javax.inject.Inject

/**
 * @author muaz
 * Created on 6/15/2022.
 */
class SearchJokesMapper @Inject constructor(
    private val jokeMapper: JokeMapper
) : Mapper<SearchJokeResponse, List<JokeUIModel>> {

    override fun map(input: SearchJokeResponse): List<JokeUIModel> {
        return input.jokesList.orEmpty().map {
            jokeMapper.map(it)
        }
    }
}
