package net.muazkadan.chucknorris.data.model.response

import com.google.gson.annotations.SerializedName

/**
 * @author muaz
 * Created on 6/15/2022.
 */
data class SearchJokeResponse(
    @SerializedName("total") val total: Int?,
    @SerializedName("result") val jokesList: List<JokeResponse>?
)
