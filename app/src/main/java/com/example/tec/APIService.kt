package com.example.tec

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APIService {
    @GET
    suspend fun getAll(@Url url:String):Response<WordsResponse>
}