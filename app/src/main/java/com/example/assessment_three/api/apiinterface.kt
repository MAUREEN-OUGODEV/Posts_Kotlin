package com.example.assessment_three.api

import com.example.assessment_three.models.PostResponse

interface APIInterface {
    @GET("/posts")
    suspend fun getPosts():Response<PostResponse>
}