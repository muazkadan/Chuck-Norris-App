package net.muazkadan.chucknorris.utils.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import net.muazkadan.chucknorris.data.base.RestResult

/**
 * @author muaz
 * Created on 6/15/2022.
 */
/**
 * * Base [ViewModel]  to standardize and simplify initialization for this component.
 */
open class BaseViewModel : ViewModel() {

    private val _loadingState = MutableStateFlow(false)
    val loadingState: StateFlow<Boolean> = _loadingState

    private val _errorMessage = Channel<String>()
    val errorMessage = _errorMessage.receiveAsFlow()

    fun <T> request(
        flow: Flow<RestResult<T>>,
        onSuccess: ((data: T) -> Unit)? = null,
        onError: (suspend (t: Exception) -> Unit)? = null,
        onLoading: (() -> Unit)? = null
    ) = viewModelScope.launch {
        flow.collect { result ->
            when (result) {
                is RestResult.Loading -> {
                    _loadingState.update { true }
                    onLoading?.invoke()
                }
                is RestResult.Success -> {
                    _loadingState.update { false }
                    onSuccess?.invoke(result.data)
                }
                is RestResult.Error -> {
                    _loadingState.update { false }
                    _errorMessage.send(result.exception.message.orEmpty())
                    onError?.invoke(result.exception)
                }
            }
        }
    }
}
