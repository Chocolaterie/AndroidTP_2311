package com.example.demoandroid.demoapi

import com.example.tpfilrouge.api.RetrofitTools.Companion.retrofit
import com.example.tpfilrouge.api.ServiceResponseDTO
import com.example.tpfilrouge.article.Article
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ArticleService {

    @GET("articles")
    suspend fun getArticles() : ServiceResponseDTO<List<Article>>

    @POST("articles/save")
    suspend fun saveArticle(@Body article : Article) : ServiceResponseDTO<Article>

    @DELETE("articles/{id}")
    suspend fun delete(@Path("id") id :String) : ServiceResponseDTO<Article>

    object ArticleApi {
        val articleService : ArticleService by lazy { retrofit.create(ArticleService::class.java) }
    }
}