package net.muazkadan.chucknorris.presentation.category

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import net.muazkadan.chucknorris.domain.usecase.GetCategoriesUseCase
import net.muazkadan.chucknorris.domain.usecase.GetRandomJokeUseCase
import net.muazkadan.chucknorris.utils.base.BaseViewModel
import javax.inject.Inject

/**
 * @author muaz
 * Created on 6/14/2022.
 */
@HiltViewModel
class CategoryViewModel @Inject constructor(
    private val getCategoriesUseCase: GetCategoriesUseCase,
    private val getRandomJokeUseCase: GetRandomJokeUseCase
) : BaseViewModel() {

    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    init {
        getCategories()
    }

    private fun getCategories() = viewModelScope.launch {
        request(
            flow = getCategoriesUseCase.invoke(),
            onSuccess = { categories ->
                _uiState.update { uiState ->
                    uiState.copy(
                        categoriesList = categories
                    )
                }
            }
        )
    }

    fun getRandomJoke(category: String) = viewModelScope.launch {
        request(
            flow = getRandomJokeUseCase.invoke(category),
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

    data class UiState(
        val categoriesList: List<String> = emptyList(),
    )
}
