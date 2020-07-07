package com.example.nytimesapp

import com.example.nytimesapp.data.ApiData
import com.example.nytimesapp.data.Film
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface NewYorkTimesApi {

    @GET("/svc/movies/v2/reviews/picks.json?api-key=EAqYE4uMlG2OMZQLANuDHYAMVD3TWZNV")
    suspend fun getListOfFilms(): ApiData
}

object NewYorkTimesApiImpl {
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create())
        .baseUrl("https://api.nytimes.com")
        .build()

    private val newYorkTimesService = retrofit.create(NewYorkTimesApi::class.java)

    suspend fun getListOfFilms(): List<Film> {
        return withContext(Dispatchers.IO) {
            newYorkTimesService.getListOfFilms()
                .results
                .map { result ->
                    Film(
                        result.title,
                        result.multimedia?.imageUrl
                    )
                }
        }
    }
}