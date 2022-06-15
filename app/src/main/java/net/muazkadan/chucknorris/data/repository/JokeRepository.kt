package net.muazkadan.chucknorris.data.repository

import net.muazkadan.chucknorris.data.base.BaseRepository
import net.muazkadan.chucknorris.data.network.CNApi
import javax.inject.Inject

/**
 * @author muaz
 * Created on 6/15/2022.
 */
class JokeRepository @Inject constructor(
    private val service: CNApi
) : BaseRepository() {

    suspend fun getRandomJoke(category: String? = null) = safeApiCall { service.getRandomJoke(category) }

    suspend fun getJokeByQuery(query: String) = safeApiCall { service.searchJokesByQuery(query) }

    suspend fun getCategories() = safeApiCall { service.getCategories() }
}
