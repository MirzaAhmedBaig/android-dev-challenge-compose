/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
