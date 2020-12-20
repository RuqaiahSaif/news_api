package com.ruqaiah.android.myapplication

import java.util.*

data class NewsData (
    var id:Int,
    var title:String,
    var details:String,
    var date: Date,
    var image:String,
    var cat_id:Int){
}