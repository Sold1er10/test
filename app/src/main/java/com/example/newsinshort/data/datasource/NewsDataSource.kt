package com.example.newsinshort.data.datasource

import com.example.newsinshort.data.api.ApiService
import com.example.newsinshort.data.entity.NewsResponse
import retrofit2.Response
import javax.inject.Inject

interface NewsDataSource {

    suspend fun getNewsHeadLine(
        country: String,
    ): Response<NewsResponse>
}

class NewsDataSourceImpl @Inject constructor(
    private val apiService: ApiService
) : NewsDataSource {

    override suspend fun getNewsHeadLine(
        country: String,
    ): Response<NewsResponse> {
        return apiService.getNewsHeadLine(country)
    }
}