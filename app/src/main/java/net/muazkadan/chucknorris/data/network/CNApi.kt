package net.muazkadan.chucknorris.data.network

import net.muazkadan.chucknorris.data.model.response.JokeResponse
import net.muazkadan.chucknorris.data.model.response.SearchJokeResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author muaz
 * Created on 6/15/2022.
 */
interface CNApi {

    @GET("random")
    suspend fun getRandomJoke(): Response<JokeResponse>

    @GET("search")
    suspend fun searchJokesByQuery(
        @Query("query") query: String
    ): Response<SearchJokeResponse>
}
