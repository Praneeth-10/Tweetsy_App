package com.lucifer.tweetsy.repository

import com.lucifer.tweetsy.api.TweetsyAPI
import com.lucifer.tweetsy.models.TweetListItem
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class TweetsRepository @Inject constructor(private val tweetsyAPI: TweetsyAPI) {


    private val _categories = MutableStateFlow<List<String>>(emptyList())
    val categories : StateFlow<List<String>>
        get() = _categories

    suspend fun getCategories(){
        val response = tweetsyAPI.getCategories()
        if (response.isSuccessful && response.body() != null){
            _categories.emit(response.body()!!.distinct())
        }
    }

    private val _tweets = MutableStateFlow<List<TweetListItem>>(emptyList())
    val tweets : StateFlow<List<TweetListItem>>
        get() = _tweets

    suspend fun getTweets(category : String){
        val response = tweetsyAPI.getTweets("tweets[?(@.category==\"$category\")]")
        delay(500L)
        if(response.isSuccessful && response.body() != null){
            _tweets.emit(response.body()!!)
        }
    }

}