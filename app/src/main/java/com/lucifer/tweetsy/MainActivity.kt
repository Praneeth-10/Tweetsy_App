package com.lucifer.tweetsy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.lucifer.tweetsy.screens.CategoryScreen
import com.lucifer.tweetsy.screens.DetailScreen
import com.lucifer.tweetsy.ui.theme.TweetsyTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            TweetsyTheme {
                // A surface container using the 'background' color from the theme

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    CategoryScreen()
                    Spacer(modifier = Modifier.height(4.dp))
                    DetailScreen()
                }
            }
        }
    }
}
