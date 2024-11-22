package com.example.examenapiretrofitroom21112024.retrofit

import retrofit2.Response
import retrofit2.http.GET

interface PostsService {
    @GET("/posts")
    suspend fun getPosts(): Response<List<PostResponse>>
}


