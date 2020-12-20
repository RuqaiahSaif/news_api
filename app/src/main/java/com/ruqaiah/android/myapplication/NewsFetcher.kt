package com.ruqaiah.android.myapplication

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import api.Newsapi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsFetcher {
    private val newApi: Newsapi

    init {
        val retrofit: Retrofit = Retrofit.
        Builder()
            .baseUrl("http://10.0.1.73")
            .addConverterFactory(
                GsonConverterFactory.create()).build()
        newApi = retrofit.create(Newsapi::class.java)
    }
    fun fetchContents(): LiveData<List<NewsData>> {
        val responseLiveData: MutableLiveData<List<NewsData>> = MutableLiveData()
        val newRequst: Call<List<NewsData>> = newApi.fetchContents()
        newRequst.enqueue(object : Callback<List<NewsData>> {
            override fun onFailure(call: Call<List<NewsData>>, t: Throwable) {
                Log.e("tag", "Failed to fetch news${t.message}")            }
            override fun onResponse(
                call: Call<List<NewsData>>,
                response: Response<List<NewsData>>
            ) {
                Log.d("tag", "Response received ${response.code().toString()} ")
                val newshResponse:List<NewsData>? = response.body()


                var newItems: List<NewsData> = newshResponse
                    ?: mutableListOf()

                responseLiveData.value = newItems
            }
        })
        return responseLiveData}
}