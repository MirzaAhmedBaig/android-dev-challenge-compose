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

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.data.models.PuppyInfo
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.viewmodel.PuppyViewModel

@Composable
fun PuppyDetailsScreen(id: Int, viewModel: PuppyViewModel, navController: NavHostController) {
    val puppyData = viewModel.findPuppy(id)

    puppyData?.let { info ->
        Scaffold(topBar = {
            AppBar(
                appBarText = info.name,
                navController = navController,
                isBackButtonToShow = true
            )
        }) {
            PuppyDetailsItem(puppyInfo = info)
        }
    }

}

@Composable
fun PuppyDetailsItem(puppyInfo: PuppyInfo) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = puppyInfo.imageResId),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))
        Text(text = puppyInfo.name, style = MaterialTheme.typography.h5)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = puppyInfo.breed, style = MaterialTheme.typography.body1)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = puppyInfo.gender, style = MaterialTheme.typography.body2)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = puppyInfo.details, style = MaterialTheme.typography.body2)

    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun PuppyDetailsLightPreview() {
    MyTheme {
        PuppyDetailsScreen(1, PuppyViewModel(), rememberNavController())
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun PuppyDetailsDarkPreview() {
    MyTheme(darkTheme = true) {
        PuppyDetailsScreen(1, PuppyViewModel(), rememberNavController())
    }
}