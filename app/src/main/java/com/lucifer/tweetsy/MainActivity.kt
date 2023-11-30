package com.lucifer.tweetsy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
                DetailScreen()
            }
        }
    }
}
