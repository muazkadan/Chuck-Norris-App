package net.muazkadan.chucknorris.domain.uimodel

/**
 * @author muaz
 * Created on 6/15/2022.
 */
data class JokeUIModel(
    val categories: String,
    val createdAt: String,
    val iconUrl: String,
    val id: String,
    val updatedAt: String,
    val url: String,
    val value: String
)
