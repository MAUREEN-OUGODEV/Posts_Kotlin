package com.example.assessment_three.api

object apiClient {

    var retrofit = Retrofit.Builder()
        .baseUrl("http://13.244.243.129")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    fun <T> buildApiClient(apiInterface: Class<T>): T {
        return retrofit.create(apiInterface)
    }
    }
}