package com.ruqaiah.android.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class NewsViewModel:ViewModel() {
    val newsLiveData :LiveData<List<NewsData>>
    init {
        newsLiveData = NewsFetcher().fetchContents();
    }
}