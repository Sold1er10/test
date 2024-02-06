package com.example.newsinshort.data.api

import com.example.newsinshort.data.entity.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("v2/top-headlines")
    suspend fun getNewsHeadLine(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String = "32323810727f4f98b5e39d2e1bf3541a"
    ): Response<NewsResponse>

    /*
        https://newsapi.org/v2/top-headlines?country=us&apiKey=32323810727f4f98b5e39d2e1bf3541a

    divide the url in parts:
    1- Quires:
    country, apiKey

    2- Get part:
    v2/top-headlines

    3- base url in AppConstants file:
    https://newsapi.org/

     */
}

