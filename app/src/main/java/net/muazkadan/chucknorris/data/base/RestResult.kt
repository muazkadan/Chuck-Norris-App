package net.muazkadan.chucknorris.data.base

/**
 * @author muaz
 * Created on 6/15/2022.
 */
sealed class RestResult<out T> {
    class Success<T>(val data: T) : RestResult<T>()
    class Error(val exception: Exception) : RestResult<Nothing>()
    object Loading : RestResult<Nothing>()
}
