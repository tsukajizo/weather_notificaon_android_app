package com.tsukajizo.weathers.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.tsukajizo.weathers.service.tomorrowio.WeatherCode
import com.tsukajizo.weathers.service.tomorrowio.WeatherForecast
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date


/**
 * com.tsukajizo.weathers.ui.home
 */
@Composable
fun HomeView(viewModel: HomeViewModel) {
    val weather = viewModel.weather.observeAsState()

    Surface {
        Column(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            weather.value?.let {
                TodayWeather(weather = weather)
                DayWeather(weather = weather)
            }
        }
    }
}

@Composable
fun TodayWeather(weather: State<WeatherForecast?>) {
    val weatherCode =
        WeatherCode.fromCode(weather.value!!.timelines.hourly[0].values.weatherCode)!!
    Text(text = weather.value!!.timelines.hourly[0].time)
    Text(text = weather.value!!.timelines.hourly[0].values.temperature!!.toInt().toString())
    Image(
        painter = painterResource(id = weatherCode.iconResId),
        contentDescription = weatherCode.toString(),
        modifier = Modifier.size(100.dp, 100.dp)
    )

    Row {
        Text(text = weather.value!!.timelines.daily[0].values.temperatureMax!!.toInt().toString())
        Text(text = weather.value!!.timelines.daily[0].values.temperatureMin!!.toInt().toString())
    }
}

@Composable
fun DayWeather(weather: State<WeatherForecast?>) {
    val hourly = weather.value!!.timelines.hourly
    Card {
        LazyRow {
            items(hourly) { item ->
                Column {
                    val weatherCode =
                        WeatherCode.fromCode(item.values.weatherCode)!!
                    val cal = Calendar.getInstance()
                    val format = SimpleDateFormat("yyyy-mm-dd'T'HH:MM:SSX")
                    cal.time = format.parse(item.time)
                    Image(
                        painter = painterResource(id = weatherCode.iconResId),
                        contentDescription = weatherCode.toString(),
                        modifier = Modifier.size(30.dp, 30.dp)
                    )
                    Text(text = cal.get(Calendar.HOUR_OF_DAY).toString())
                    Text(text = item.values.temperature!!.toInt().toString())

                }
            }
        }
    }
}


@Composable
fun WeeklyWeather() {

}

@Composable
fun OtherInformation() {

}