package com.example.myfirstapplication
import retrofit2.http.GET
import retrofit2.http.Path

interface DictionaryApi {
    @GET("en/{word}")
    suspend fun getWord(@Path("word") word: String): Word
}