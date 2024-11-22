package com.example.examenapiretrofitroom21112024.ui

import androidx.lifecycle.ViewModel
import com.example.examenapiretrofitroom21112024.retrofit.PostRepository
import com.example.examenapiretrofitroom21112024.retrofit.PostsService
import com.example.examenapiretrofitroom21112024.retrofit.retrofit
import retrofit2.Retrofit

class PostViewModel: ViewModel() {
    val postService = retrofit.create(PostsService::class.java)
    val repository = PostRepository(postService)

    suspend fun foo() {
        repository.fetchPosts()
    }
}