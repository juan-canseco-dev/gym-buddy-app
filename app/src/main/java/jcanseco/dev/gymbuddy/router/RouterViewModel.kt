package jcanseco.dev.gymbuddy.router

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class RouterViewModel : ViewModel() {

    private val _routerState = MutableLiveData<RouterState?>(null)
    val routerState : LiveData<RouterState?> get() = _routerState

    private val _loading = MutableLiveData(true)
    val loading : LiveData<Boolean> get() = _loading

    init {
        viewModelScope.launch {
            delay(5000)
            _routerState.value = RouterState.UserAuthenticated
            _loading.value = false
        }
    }
}

sealed class RouterState {
    data object UserAuthenticated: RouterState()
    data object UserAuthenticatedWithProfileIncomplete : RouterState()
    data object UserUnauthenticated : RouterState()
}