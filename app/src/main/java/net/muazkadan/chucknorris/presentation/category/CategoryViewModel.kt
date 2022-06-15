package net.muazkadan.chucknorris.presentation.category

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import net.muazkadan.chucknorris.domain.usecase.GetCategoriesUseCase
import net.muazkadan.chucknorris.utils.base.BaseViewModel
import javax.inject.Inject

/**
 * @author muaz
 * Created on 6/14/2022.
 */
@HiltViewModel
class CategoryViewModel @Inject constructor(
    private val getCategoriesUseCase: GetCategoriesUseCase
) : BaseViewModel() {

    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState

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

    data class UiState(
        val categoriesList: List<String> = emptyList(),
    )
}
