package com.ma.basloq.android.feature.auth

import BasloqOutlineTextField
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import com.ma.basloq.android.common.UiEvent
import com.ma.basloq.android.components.material.padding
import com.ma.basloq.android.components.screens.LoadingScreen
import com.ma.basloq.android.feature.auth.component.AuthFooter
import com.ma.basloq.android.feature.auth.component.AuthHeader


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun LoginScreen(
    viewModel: AuthViewModel,
    snackbarHostState: SnackbarHostState,
    onNavigateToHome: () -> Unit,
    onNaviagteToRegister: () -> Unit
) {
    val state = viewModel.loginState
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current
    LaunchedEffect(key1 = viewModel.uiEvent) {
        viewModel.uiEvent.collect { event ->
            when (event) {
                is UiEvent.ShowSnackbar -> {
                    keyboardController?.hide()
                    snackbarHostState.showSnackbar(message = event.message)
                }

                is UiEvent.NavigateUp -> onNavigateToHome()
            }
        }
    }
    LaunchedEffect(key1 = state.isLoading) {
        if (state.isLoading == true) {
            keyboardController?.hide()
        }
    }

    Column(
        modifier = Modifier
            .padding(horizontal = MaterialTheme.padding.medium)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        AuthHeader(
            headlineText = "Welcome Back!",
            subHeadlineText = "Good to see you again, let's login.",
        )
        BasloqOutlineTextField(
            modifier = Modifier
                .padding(top = MaterialTheme.padding.large)
                .fillMaxWidth(),
            value = state.username,
            onValueChange = { viewModel.onLoginUsernameChange(it) },
            label = "username",
            isError = state.isUsernameInputError,
            errorMessage = "Email is Invalid!"
        )
        BasloqOutlineTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = state.password,
            onValueChange = { viewModel.onLoginPasswordChange(it) },
            label = "password",
            isError = state.isPasswordInputError,
            errorMessage = "Password should be 5-20 characters."
        )
        AuthFooter(
            authTextAction = "Login",
            onAuthActionClick = {
                focusManager.clearFocus()
                if (state.username.isEmpty() || state.isUsernameInputError ||
                    state.password.isEmpty() || state.isPasswordInputError
                ) {
                    return@AuthFooter
                }
                viewModel.login(username = state.username, password = state.password)
            },
            onOtherAction = { onNaviagteToRegister() },
            authTextHint = "Are you a new user?",
            otherTextAction = "Create Account",
        )
    }
    LoadingScreen(
        modifier = Modifier.fillMaxSize(),
        displayProgressBar = state.isLoading
    )
}
