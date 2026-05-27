package com.example.dependancyinjection_2

import retrofit2.http.GET
import retrofit2.http.Query

interface UsersAPIService {

    @GET("character")
    suspend fun getPosts(
        @Query("page")page : Int
    ): Users
}
