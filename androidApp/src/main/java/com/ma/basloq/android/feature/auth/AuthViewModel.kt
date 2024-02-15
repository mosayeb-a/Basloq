package com.ma.basloq.android.feature.auth

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ma.basloq.common.BasloqException
import com.ma.basloq.data.repo.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject



@HiltViewModel
class AuthViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    var state by mutableStateOf(RegisterState())
        private set

    // todo when createUser operation is successful, navigate to the home screen and clear the back stack
    fun createUser(
        email: String,
        password: String,
        username: String
    ) {
        viewModelScope.launch {
            state = state.copy(isLoading = true)
            try {
                val result = userRepository.createUser(
                    email = email,
                    password = password,
                    username = username
                )
                state = state.copy(
                    email = email,
                    password = password,
                    username = username,
                    token = result.userToken!!,
                    isLoading = false
                )
            } catch (e: BasloqException) {
                state = state.copy(
                    error = e,
                    isLoading = false
                )
            }
        }
    }
}
