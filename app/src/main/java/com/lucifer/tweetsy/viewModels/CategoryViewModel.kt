package com.lucifer.tweetsy.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lucifer.tweetsy.repository.TweetsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(private val tRepository: TweetsRepository) : ViewModel() {

    val categories : StateFlow<List<String>>
        get() = tRepository.categories

    init {
        viewModelScope.launch {
            tRepository.getCategories()
        }
    }
}