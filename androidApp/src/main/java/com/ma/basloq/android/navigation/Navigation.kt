package com.ma.basloq.android.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.ma.basloq.android.feature.auth.AuthViewModel
import com.ma.basloq.android.feature.auth.LoginScreen
import com.ma.basloq.android.feature.detail.DetailScreen
import com.ma.basloq.android.feature.detail.DetailViewModel
import com.ma.basloq.android.feature.list.QuoteListScreen
import com.ma.basloq.android.feature.list.QuoteListViewModel
import com.ma.basloq.android.feature.auth.RegisterScreen

@Composable
fun Navigation(
    snackbarHostState: SnackbarHostState
) {
    val navController = rememberNavController()
    NavHost(
        modifier = Modifier.fillMaxSize(),
        navController = navController,
        startDestination = Route.Authorization
    ) {
        navigation(
            route = Route.Authorization,
            startDestination = Route.Register,
        ) {
            composable(route = Route.Login) { backStackEntry ->
                val parentEntry = remember(backStackEntry) {
                    navController.getBackStackEntry(Route.Authorization)
                }
                val viewModel: AuthViewModel = hiltViewModel(parentEntry)
                LoginScreen(
                    viewModel = viewModel,
                    snackbarHostState = snackbarHostState,
                    onNavigateToHome = {
                        navController.navigate(Route.QuoteList)
                    },
                    onNaviagteToRegister = {
                        navController.navigate(Route.Register)
                    }
                )
            }
            composable(route = Route.Register) { backStackEntry ->
                val parentEntry = remember(backStackEntry) {
                    navController.getBackStackEntry(Route.Authorization)
                }
                val viewModel: AuthViewModel = hiltViewModel(parentEntry)
                if (viewModel.isUserAuthenticated) {
                    navController.navigate(Route.QuoteList)
                    return@composable
                }
                RegisterScreen(
                    viewModel = viewModel,
                    snackbarHostState = snackbarHostState,
                    onNavigateToHome = {
                        navController.navigate(Route.QuoteList)
                    },
                    onNavigateToLogin = {
                        navController.navigate(Route.Login)
                    }
                )
            }
        }
        composable(route = Route.QuoteList) { navBackStackEntry ->
            val viewModel: QuoteListViewModel = hiltViewModel(navBackStackEntry)
            QuoteListScreen(
                onQuoteClick = { quoteId ->
                    navController.navigate(Route.Detail + "/$quoteId")
                },
                viewModel = viewModel
            )
        }
        composable(
            route = Route.Detail + "/{quoteId}",
            arguments = listOf(
                navArgument("quoteId") {
                    type = NavType.IntType
                }
            )
        ) { navBackStackEntry ->
            val viewModel: DetailViewModel = hiltViewModel(navBackStackEntry)
            DetailScreen(
                viewModel.state
            )
        }

    }
}