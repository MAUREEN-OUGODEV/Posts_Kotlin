package com.example.assessment_three.repository

import com.example.assessment_three.api.APIInterface
import com.example.assessment_three.api.apiClient
import com.example.assessment_three.models.PostResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class postRepository {
    val apiClient = apiClient.buildClient(APIInterface::class.java)

    suspend fun getProducts(): Response<PostResponse> {
        return withContext(Dispatchers.IO) {
            apiClient.getPosts()
        }
    }
    }