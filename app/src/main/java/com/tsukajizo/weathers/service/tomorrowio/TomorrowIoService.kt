package com.tsukajizo.weathers.service.tomorrowio

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * com.tsukajizo.weathers
 */
interface TomorrowIoService {
    @GET("/v4/weather/forecast")
    suspend fun getWeatherInfo(
        @Query("location") lat: String,
        @Query("apikey") apikey: String,
    ): Response<WeatherForecast>
}