package com.example.androiddevchallenge.ui.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.example.androiddevchallenge.R

@Composable
fun AppBar(
    appBarText: String,
    navController: NavHostController,
    isBackButtonToShow: Boolean = false
) {
    TopAppBar(
        title = { Text(text = appBarText) },
        navigationIcon = {
            IconButton(
                onClick = {
                    if (isBackButtonToShow)
                        navController.popBackStack()
                }
            ) {
                Icon(
                    painter = painterResource(id = if (isBackButtonToShow) R.drawable.ic_baseline_arrow_back_24 else R.drawable.ic_dog),
                    contentDescription = "back_button"
                )
            }
        }
    )

}