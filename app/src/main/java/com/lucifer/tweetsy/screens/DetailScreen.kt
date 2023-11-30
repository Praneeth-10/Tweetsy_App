package com.lucifer.tweetsy.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.lucifer.tweetsy.models.TweetListItem
import com.lucifer.tweetsy.viewModels.DetailViewModel

@Composable
fun DetailScreen() {
    val detailViewModel : DetailViewModel = viewModel()
    val tweetItems: State<List<TweetListItem>> = detailViewModel.tweets.collectAsState()
    LazyColumn(content = {
        items(tweetItems.value){
            DetailScreenItem(tweetListItem = it)
        }
    })
}

@Composable
fun DetailScreenItem(tweetListItem: TweetListItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        border = BorderStroke(1.dp, Color(0xFFCCCCCC))
    ) {
        Text(text = tweetListItem.text, modifier = Modifier.padding(16.dp), style = MaterialTheme.typography.titleMedium)
//        Spacer(modifier = Modifier.height(2.dp))
        Text(text = tweetListItem.category, modifier = Modifier.padding(16.dp).align(Alignment.CenterHorizontally), style = MaterialTheme.typography.bodyMedium)
    }
}