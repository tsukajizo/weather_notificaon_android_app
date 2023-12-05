package com.tsukajizo.weathers.ui.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tsukajizo.weathers.models.weather.WeatherRepository
import com.tsukajizo.weathers.service.tomorrowio.WeatherForecast
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * com.tsukajizo.weathers.ui.home
 */
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val weatherRepository: WeatherRepository
) : ViewModel(){

    val weather:MutableLiveData<WeatherForecast> by lazy {
        MutableLiveData<WeatherForecast>()
    }


    fun getWeather(){
        viewModelScope.launch {
            val result  = weatherRepository.getWeatherInfo(
                35.6894,
                139.6917,
            )

            weather.value =  result

            Log.d("test", weather.toString())
            
        }
    }

}