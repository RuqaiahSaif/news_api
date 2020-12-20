package api

import com.ruqaiah.android.myapplication.NewsData
import retrofit2.Call
import retrofit2.http.GET

interface Newsapi {
    @GET("/coding_news/api/news_api.php")
    fun fetchContents(): Call<List<NewsData>>
}