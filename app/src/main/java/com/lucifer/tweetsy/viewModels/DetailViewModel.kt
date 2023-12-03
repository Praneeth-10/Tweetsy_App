package com.lucifer.tweetsy.viewModels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lucifer.tweetsy.models.TweetListItem
import com.lucifer.tweetsy.repository.TweetsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val tRepository: TweetsRepository,
    private val savedStateHandle: SavedStateHandle) : ViewModel() {

    val tweets : StateFlow<List<TweetListItem>>
        get() = tRepository.tweets

    init {
        viewModelScope.launch{
            val categoryIs = savedStateHandle.get<String>("category") ?: "motivation"
            tRepository.getTweets(categoryIs)
        }
    }

}