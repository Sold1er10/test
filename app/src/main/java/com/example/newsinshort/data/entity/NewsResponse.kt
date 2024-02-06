package com.example.newsinshort.data.entity

data class NewsResponse(
    val articles: List<Article>,
    val status: String? = "No Author",
    val totalResults: Int
)

data class Article(
    val author: String? = "No Author",
    val content: String? = "No Author",
    val description: String? = "No Author",
    val publishedAt: String? = "No Author",
    val source: Source,
    val title: String? = "No Author",
    val url: String? = "No Author",
    val urlToImage: String? = "No Author"
)

data class Source(
    val id: String? = "hh",
    val name: String? = "No Author"
)