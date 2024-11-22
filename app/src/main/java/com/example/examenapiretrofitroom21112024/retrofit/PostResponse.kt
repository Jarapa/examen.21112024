package com.example.examenapiretrofitroom21112024.retrofit

import com.example.examenapiretrofitroom21112024.domain.Post
import com.google.gson.annotations.SerializedName

data class PostResponse(
    @SerializedName("userId")
    val userId: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("body")
    val body: String,

)

fun List<PostResponse>.toDomain(): List<Post> {
    return this.map { it.toDomain() }
}

fun PostResponse.toDomain(): Post {
    return Post(
        userId = userId,
        id = id,
        title = title,
        body = body
    )
}