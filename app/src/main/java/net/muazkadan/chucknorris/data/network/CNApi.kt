package net.muazkadan.chucknorris.data.network

import net.muazkadan.chucknorris.data.model.response.RandomJokeResponse
import retrofit2.Response
import retrofit2.http.GET

/**
 * @author muaz
 * Created on 6/15/2022.
 */
interface CNApi {

    @GET("random")
    suspend fun getRandomJoke(): Response<RandomJokeResponse>
}
