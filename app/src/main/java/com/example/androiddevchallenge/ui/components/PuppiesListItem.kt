package com.example.androiddevchallenge.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.models.PuppyInfo
import com.example.androiddevchallenge.data.repository.DataRepository
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun PuppiesListItem(puppyInfo: PuppyInfo, modifier: Modifier = Modifier) {
    Row(
        modifier
            .fillMaxWidth()
            .padding(start = 16.dp, top = 8.dp, end = 16.dp, bottom = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = puppyInfo.imageResId),
            contentDescription = null,
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column(Modifier.fillMaxWidth()) {
            Text(text = puppyInfo.name, style = MaterialTheme.typography.h6)
            Text(text = puppyInfo.breed, style = MaterialTheme.typography.body1)
            Text(text = puppyInfo.gender, style = MaterialTheme.typography.body2)
        }
    }
}

@Preview("Light them", widthDp = 360, heightDp = 140)
@Composable
fun LightPreview() {
    MyTheme {
        PuppiesListItem(puppyInfo = DataRepository.puppiesInfoList.first())
    }
}

@Preview("Dark them", widthDp = 360, heightDp = 140)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        PuppiesListItem(puppyInfo = DataRepository.puppiesInfoList.first())
    }
}