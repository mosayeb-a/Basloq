package com.ma.basloq.android.navigation


sealed class Screen(val route : String) {
    data object QuoteList : Screen("quote_list")
    data object Detail : Screen("detail")
    data object Authorization : Screen("authorization")
    data object SignUp : Screen("signUp")
    data object Login : Screen("login")
    data object Profile : Screen("profile")
}

