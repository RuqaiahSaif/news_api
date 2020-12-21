package com.ruqaiah.android.myapplication

import java.util.*

data class NewsData (
    var id:Int,
      @SerializedName("news_title")
    var title:String,
     @SerializedName("news_details")
    var details:String,
    @SerializedName("news_date")
    var date: Date,
     @SerializedName("news_image")
    var image:String,
       @SerializedName("id_cat")
    var cat_id:Int){
}
