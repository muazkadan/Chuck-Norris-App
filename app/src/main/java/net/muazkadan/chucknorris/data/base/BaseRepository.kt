package net.muazkadan.chucknorris.data.base

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import org.json.JSONObject
import retrofit2.Response
import java.io.IOException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

/**
 * @author muaz
 * Created on 6/15/2022.
 */
abstract class BaseRepository {

    fun <T : Any> safeApiCall(
        call: suspend () -> Response<T>
    ): Flow<RestResult<T>> = flow {
        emit(RestResult.Loading)
        val response = call.invoke()
        val responseBody = response.body()
        if (response.isSuccessful && responseBody != null) {
            emit(RestResult.Success(responseBody))
        } else {
            val responseError = response.errorBody()
            if (responseError != null) {
                if (response.code() == 500) {
                    val jObjError = JSONObject(responseError.string())
                    emit(RestResult.Error(java.lang.Exception(jObjError.get("message").toString())))
                } else {
                    emit(RestResult.Error(Exception(responseError.string())))
                }
            } else {
                emit(RestResult.Error(Exception("Unknown Error")))
            }
        }
    }.catch { error ->
        error.printStackTrace()
        when (error) {
            is IOException, is UnknownHostException, is SocketTimeoutException -> {
                emit(RestResult.Error(IOException("Something went wrong, please check your internet connection")))
            }
            else -> {
                emit(RestResult.Error(Exception(error)))
            }
        }
    }.flowOn(Dispatchers.IO)
}
