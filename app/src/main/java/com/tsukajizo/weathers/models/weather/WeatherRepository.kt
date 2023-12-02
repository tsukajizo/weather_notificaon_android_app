package com.tsukajizo.weathers.models.weather

import android.util.Log
import com.tsukajizo.weathers.BuildConfig
import com.tsukajizo.weathers.service.tomorrowio.TomorrowIoService
import com.tsukajizo.weathers.service.tomorrowio.WeatherForecast
import retrofit2.HttpException
import javax.inject.Inject
import javax.inject.Singleton

/**
 * com.tsukajizo.weathers.service.open_weather_map
 */
@Singleton
class WeatherRepository @Inject constructor(private val service: TomorrowIoService) {

    suspend fun getWeatherInfo(
        lat: Double,
        lon: Double,
    ): WeatherForecast? {
        try {
            return service.getWeatherInfo(
                "${lat},${lon}",
                BuildConfig.TOMORROW_IO_API_KEY,
            ).body()
        } catch (e: HttpException) {
            Log.d("test", e.message())
            return null
        }

    }
}