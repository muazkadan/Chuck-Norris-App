package net.muazkadan.chucknorris.presentation.home.search

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import net.muazkadan.chucknorris.domain.uimodel.JokeUIModel
import net.muazkadan.chucknorris.domain.usecase.GetJokesByQueryUseCase
import net.muazkadan.chucknorris.utils.base.BaseViewModel
import javax.inject.Inject

/**
 * @author muaz
 * Created on 6/15/2022.
 */
@HiltViewModel
class SearchViewModel @Inject constructor(
    private val getJokesByQuery: GetJokesByQueryUseCase
) : BaseViewModel() {

    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState

    fun getJokes(query: String) {
        viewModelScope.launch {
            request(
                flow = getJokesByQuery.invoke(query),
                onSuccess = { list ->
                    _uiState.update { uiState ->
                        uiState.copy(
                            jokesList = list
                        )
                    }
                }
            )
        }
    }

    data class UiState(
        val jokesList: List<JokeUIModel> = emptyList(),
    )
}
