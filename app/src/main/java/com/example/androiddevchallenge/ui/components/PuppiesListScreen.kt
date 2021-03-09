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
package com.example.androiddevchallenge.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.data.constants.DETAILS_PAGE
import com.example.androiddevchallenge.data.models.PuppyInfo
import com.example.androiddevchallenge.viewmodel.PuppyViewModel

@Composable
fun PuppiesListScreen(viewModel: PuppyViewModel, navController: NavHostController) {
    val puppies = viewModel.puppyInfoList.observeAsState()

    puppies.value?.let { puppiesList ->
        Scaffold(topBar = { AppBar(appBarText = "Adopt Puppy", navController = navController) }) {
            PuppiesList(puppiesList = puppiesList) {
                navController.navigate("$DETAILS_PAGE/${it.id}")
            }
        }
    }
}

@Composable
fun PuppiesList(puppiesList: List<PuppyInfo>, onClick: (PuppyInfo) -> Unit) {
    LazyColumn {
        items(puppiesList.size) { index ->
            Card(modifier = Modifier.clickable { onClick(puppiesList[index]) }) {
                PuppiesListItem(puppyInfo = puppiesList[index])
            }
            Spacer(modifier = Modifier.size(8.dp))
        }
    }
}