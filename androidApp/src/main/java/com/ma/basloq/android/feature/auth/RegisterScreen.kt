package com.ma.basloq.android.feature.auth

import BasloqOutlineTextField
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
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
import androidx.compose.ui.unit.dp
import com.ma.basloq.android.common.UiEvent
import com.ma.basloq.android.components.material.padding
import com.ma.basloq.android.components.screens.LoadingScreen
import com.ma.basloq.android.feature.auth.component.AuthFooter
import com.ma.basloq.android.feature.auth.component.AuthHeader


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun RegisterScreen(
    viewModel: AuthViewModel,
    snackbarHostState: SnackbarHostState,
    onNavigateToHome: () -> Unit,
    onNavigateToLogin: () -> Unit
) {
    val state = viewModel.registerState
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
            .padding(start = 16.dp, end = 16.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        AuthHeader(
            headlineText = "Hi There!",
            subHeadlineText = "Create an account to express your thoughts freely.",
        )
        Row(
            modifier = Modifier
                .padding(top = MaterialTheme.padding.extraLarge)
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            BasloqOutlineTextField(
                modifier = Modifier
                    .padding(end = MaterialTheme.padding.small)
                    .weight(1.6f),
                value = state.username,
                label = "username",
                onValueChange = { viewModel.onRegisterUsernameChange(it) },
                isError = state.isUsernameInputError,
                errorMessage = ""
            )
            BasloqOutlineTextField(
                modifier = Modifier
                    .weight(2.3f),
                value = state.password,
                label = "password",
                onValueChange = { viewModel.onRegisterPasswordChange(it) },
                isError = state.isPasswordInputError,
                errorMessage = "Password should be 5-20 characters."
            )
        }

        BasloqOutlineTextField(
            modifier = Modifier
                .padding(top = MaterialTheme.padding.small)
                .fillMaxWidth(),
            value = state.email,
            label = "email",
            onValueChange = { viewModel.onRegisterEmailChange(it) },
            isError = state.isEmailInputError,
            errorMessage = "Email is Invalid!"
        )

        AuthFooter(
            authTextAction = "Create Account",
            onAuthActionClick = {
                focusManager.clearFocus()
                if (
                    state.username.isEmpty() || state.isUsernameInputError ||
                    state.password.isEmpty() || state.isPasswordInputError ||
                    state.email.isEmpty() || state.isEmailInputError
                ) {
                    return@AuthFooter
                }
                // todo "the textfield should be shake")
                viewModel.createUser(
                    email = state.email,
                    password = state.password,
                    username = state.username
                )
            },
            onOtherAction = { onNavigateToLogin() },
            otherTextAction = "Let's Login",
            authTextHint = "Have you already an account?",
        )
    }
    LoadingScreen(
        modifier = Modifier.fillMaxSize(),
        displayProgressBar = state.isLoading
    )
}