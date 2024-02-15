package com.ma.basloq.android.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.ma.basloq.android.feature.detail.DetailScreen
import com.ma.basloq.android.feature.detail.DetailViewModel
import com.ma.basloq.android.feature.list.QuoteListScreen
import com.ma.basloq.android.feature.list.QuoteListViewModel

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.QuoteList.route
    ) {
        navigation(
            route = Screen.Authorization.route,
            startDestination = Screen.Login.route,
        ) {

            composable(route = Screen.Login.route) { backStackEntry ->
//                val parentEntry = remember(backStackEntry){
//                    navController.getBackStackEntry( Screen.Authorization.route)
//                }
//                val viewModel : LoginViewModel= hiltViewModel(parentEntry)
            }
            composable(route = Screen.SignUp.route) {

            }
        }
        composable(route = Screen.QuoteList.route) { navBackStackEntry ->
            val viewModel: QuoteListViewModel = hiltViewModel(navBackStackEntry)
            QuoteListScreen(
                onQuoteClick = { quoteId ->
                    navController.navigate(Screen.Detail.route + "/$quoteId")
                },
                state = viewModel.state
            )
        }
        composable(
            route = Screen.Detail.route + "/{quoteId}",
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