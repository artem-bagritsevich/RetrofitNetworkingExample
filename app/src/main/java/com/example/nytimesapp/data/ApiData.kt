package com.example.nytimesapp.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiData(
    @Json(name = "status") val status: String,
    @Json(name = "results") val results: List<Result>
)

@JsonClass(generateAdapter = true)
data class Result(
    @Json(name = "display_title") val title: String?,
    @Json(name = "multimedia") val multimedia: Multimedia?
)

@JsonClass(generateAdapter = true)
data class Multimedia(
    @Json(name = "src") val imageUrl: String?
)