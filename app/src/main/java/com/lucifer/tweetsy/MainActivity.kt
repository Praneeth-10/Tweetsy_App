package com.lucifer.tweetsy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
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
                App()
            }
        }
    }
}

@Composable
fun App() {
    val navControl = rememberNavController()
    NavHost(navController = navControl, startDestination = "categoryScreen"){
        composable(route = "categoryScreen"){
            CategoryScreen{
                navControl.navigate("detailScreen/$it")
            }
        }
        composable(route = "detailScreen/{category}", arguments = listOf(
            navArgument(name = "category"){
                type = NavType.StringType
            }
        )){
            DetailScreen()
        }
    }
}
