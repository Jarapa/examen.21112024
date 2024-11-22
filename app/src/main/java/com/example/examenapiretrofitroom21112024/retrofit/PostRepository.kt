package com.example.examenapiretrofitroom21112024.retrofit

import DataError
import com.example.examenapiretrofitroom21112024.domain.Post

class PostRepository(
    private val postService: PostsService
) {
    suspend fun fetchPosts(): ApiResult<List<Post>, DataError.Network> {
        return safeCall {
            postService.getPosts()
        }.map {
            it.toDomain()
        }
    }
}
