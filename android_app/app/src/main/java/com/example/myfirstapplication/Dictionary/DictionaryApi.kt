package com.example.myfirstapplication.Dictionary
import retrofit2.http.GET
import retrofit2.http.Path

interface DictionaryApi {
    @GET("en/{word}")
    suspend fun getWord(@Path("word") word: String): List<Word>
}