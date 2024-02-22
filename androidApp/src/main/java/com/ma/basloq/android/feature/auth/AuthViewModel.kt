package com.ma.basloq.android.feature.auth

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ma.basloq.android.common.UiEvent
import com.ma.basloq.android.common.isPasswordFormatCorrect
import com.ma.basloq.android.common.isUsernameFormatCorrect
import com.ma.basloq.common.BasloqException
import com.ma.basloq.data.repo.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class AuthViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    var registerState by mutableStateOf(RegisterState())
        private set

    var loginState by mutableStateOf(LoginState())
        private set

    val isUserAuthenticated: Boolean
        get() : Boolean {
            if (
                !userRepository.loadUserToken().isNullOrEmpty() ||
                !userRepository.loadSessionToken().isNullOrEmpty()
            ) {
                return true
            }
            return false
        }

    fun createUser(
        email: String,
        password: String,
        username: String
    ) {
        viewModelScope.launch {
            registerState = registerState.copy(isLoading = true)
            try {
                val result = userRepository.createUser(
                    email = email,
                    password = password,
                    username = username
                )
                delay(1000)
                registerState = registerState.copy(
                    email = email,
                    password = password,
                    username = username,
                    token = result.userToken!!,
                    isLoading = false
                )
                _uiEvent.send(UiEvent.NavigateUp)
            } catch (e: Throwable) {
                registerState = registerState.copy(
                    error = e as BasloqException,
                    isLoading = false
                )
                when (registerState.error?.type) {
                    BasloqException.Type.SIMPLE -> {
                        _uiEvent.send(
                            UiEvent.ShowSnackbar(
                                message = registerState.error?.userFriendlyMessage.toString()
                            )
                        )
                    }

                    BasloqException.Type.EMPTY_SCREEN -> {
                        _uiEvent.send(
                            UiEvent.ShowSnackbar(
                                message = registerState.error?.userFriendlyMessage.toString()
                            )
                        )
                    }

                    else -> Unit
                }
            }
        }
    }

    fun login(username: String, password: String) {
        viewModelScope.launch {
            loginState = loginState.copy(isLoading = true)
            try {
                val result =
                    userRepository.createSession(username = username, password = password)
                loginState = loginState.copy(
                    username = username,
                    isLoading = false,
                    password = password,
                    token = result.sessionToken.toString(),
                )
//                delay(500)
                _uiEvent.send(UiEvent.NavigateUp)
            } catch (e: Throwable) {
                loginState =
                    loginState.copy(isLoading = false, error = e as BasloqException)
                when (loginState.error?.type) {
                    BasloqException.Type.SIMPLE -> {
                        _uiEvent.send(
                            UiEvent.ShowSnackbar(
                                message = loginState.error?.userFriendlyMessage.toString()
                            )
                        )
                    }

                    BasloqException.Type.EMPTY_SCREEN -> {
                        _uiEvent.send(
                            UiEvent.ShowSnackbar(
                                message = loginState.error?.userFriendlyMessage.toString()
                            )
                        )
                    }

                    else -> Unit
                }
            }
        }
    }

    fun onLoginPasswordChange(value: String) {
        loginState = loginState.copy(
            password = value,
            isPasswordInputError = !isPasswordFormatCorrect(value)
        )
    }

    fun onLoginUsernameChange(value: String) {
        loginState = loginState.copy(
            username = value,
            isUsernameInputError = !isUsernameFormatCorrect(value)
        )
    }

    fun onRegisterPasswordChange(value: String) {
        this.registerState = registerState.copy(
            password = value,
            isPasswordInputError = !isPasswordFormatCorrect(value)
        )
    }

    fun onRegisterEmailChange(value: String) {
        this.registerState = registerState.copy(
            email = value,
            isEmailInputError = !registerState.isEmailFormatCorrect()
        )
    }

    fun onRegisterUsernameChange(value: String) {
        this.registerState = registerState.copy(
            username = value,
            isUsernameInputError = !isUsernameFormatCorrect(value)
        )
    }
}
