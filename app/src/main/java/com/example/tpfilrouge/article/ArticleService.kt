package com.example.demoandroid.demoapi

import com.example.tpfilrouge.api.RetrofitTools.Companion.retrofit
import com.example.tpfilrouge.api.ServiceResponseDTO
import com.example.tpfilrouge.article.Article
import retrofit2.http.GET

interface ArticleService {

    @GET("articles")
    suspend fun getArticles() : ServiceResponseDTO<List<Article>>

    object ArticleApi {
        val articleService : ArticleService by lazy { retrofit.create(ArticleService::class.java) }
    }
}