package com.example.androiddevchallenge.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import com.example.androiddevchallenge.data.constants.DETAILS_PAGE_ROUTE
import com.example.androiddevchallenge.data.constants.LIST_PAGE_ROUTE
import com.example.androiddevchallenge.ui.components.PuppiesListScreen
import com.example.androiddevchallenge.ui.components.PuppyDetailsScreen
import com.example.androiddevchallenge.viewmodel.PuppyViewModel

@Composable
fun MainNavigationControl(navController: NavHostController) {
    val puppyViewModel = PuppyViewModel()
    NavHost(navController = navController, startDestination = LIST_PAGE_ROUTE) {
        composable(LIST_PAGE_ROUTE) {
            PuppiesListScreen(viewModel = puppyViewModel, navController = navController)
        }
        composable(
            DETAILS_PAGE_ROUTE,
            arguments = listOf(
                navArgument("id") { type = NavType.IntType }
            )
        ) {
            val puppyId = it.arguments?.getInt("id") ?: -1
            PuppyDetailsScreen(
                id = puppyId,
                viewModel = puppyViewModel,
                navController = navController
            )
        }
    }

}