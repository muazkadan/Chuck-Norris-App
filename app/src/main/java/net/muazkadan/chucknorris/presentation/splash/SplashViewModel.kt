package net.muazkadan.chucknorris.presentation.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author muaz
 * Created on 6/14/2022.
 */
@HiltViewModel
class SplashViewModel @Inject constructor() : ViewModel() {

    private val _navigationEvent = Channel<Boolean>()
    val navigationEvent = _navigationEvent.receiveAsFlow()

    init {
        startSplash()
    }

    private fun startSplash() = viewModelScope.launch {
        delay(MIN_DURATION)
        _navigationEvent.send(true)
    }

    companion object {
        const val MIN_DURATION: Long = 2000
    }
}
