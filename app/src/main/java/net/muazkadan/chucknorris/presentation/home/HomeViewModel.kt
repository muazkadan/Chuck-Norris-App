package net.muazkadan.chucknorris.presentation.home

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import net.muazkadan.chucknorris.domain.usecase.GetRandomJokeUseCase
import net.muazkadan.chucknorris.utils.base.BaseViewModel
import javax.inject.Inject

/**
 * @author muaz
 * Created on 6/14/2022.
 */
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getRandomJokeUseCase: GetRandomJokeUseCase
) : BaseViewModel() {

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun getRandomJoke() = viewModelScope.launch {
        request(
            flow = getRandomJokeUseCase.invoke(),
            onSuccess = { uiModel ->
                viewModelScope.launch {
                    _uiEvent.send(
                        UiEvent(
                            randomJoke = uiModel.value
                        )
                    )
                }
            }
        )
    }

    data class UiEvent(
        val randomJoke: String? = null
    )
}
