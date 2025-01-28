package com.example.tpfilrouge.auth

import com.example.tpfilrouge.api.RetrofitTools.Companion.retrofit
import com.example.tpfilrouge.api.ServiceResponseDTO
import com.example.tpfilrouge.article.Article
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface AuthService {

    @POST("login")
    suspend fun login(@Body loginRequestDTO: LoginRequestDTO) : ServiceResponseDTO<String>

    @POST("signup")
    suspend fun signup(@Body signUpRequestDTO: SignUpRequestDTO) : ServiceResponseDTO<SignUpRequestDTO>

    object AuthApi {
        val authService : AuthService by lazy { retrofit.create(AuthService::class.java) }
    }

}