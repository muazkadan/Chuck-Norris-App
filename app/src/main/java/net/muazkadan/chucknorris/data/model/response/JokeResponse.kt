package net.muazkadan.chucknorris.data.model.response

import com.google.gson.annotations.SerializedName
import java.util.Date

/**
 * @author muaz
 * Created on 6/15/2022.
 */
data class JokeResponse(
    @SerializedName("categories") val categories: List<String>?,
    @SerializedName("created_at") val createdAt: Date?,
    @SerializedName("icon_url") val iconUrl: String?,
    @SerializedName("id") val id: String?,
    @SerializedName("updated_at") val updatedAt: Date?,
    @SerializedName("url") val url: String?,
    @SerializedName("value") val value: String?
)
