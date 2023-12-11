package com.tsukajizo.weathers.ui.home

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.unit.sp
import com.tsukajizo.weathers.service.tomorrowio.WeatherCode
import com.tsukajizo.weathers.service.tomorrowio.WeatherForecast
import com.tsukajizo.weathers.utils.getJPDayOfWeek
import com.tsukajizo.weathers.utils.isoToCalendar

import com.tsukajizo.weathers.utils.toDateString
import com.tsukajizo.weathers.utils.toDayOfMonthString
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
                WeeklyWeather(weather = weather)
            }
        }
    }
}

@Composable
fun TodayWeather(weather: State<WeatherForecast?>) {
    val weatherCode =
        WeatherCode.fromCode(weather.value!!.timelines.hourly[0].values.weatherCode)!!
    val cal = weather.value!!.timelines.hourly[0].time.isoToCalendar()
    Text(text = cal.toDayOfMonthString())
    Text(
        text = "${weather.value!!.timelines.hourly[0].values.temperature!!.toInt()}℃",
        fontSize = 50.sp
    )
    Image(
        painter = painterResource(id = weatherCode.iconResId),
        contentDescription = weatherCode.toString(),
        modifier = Modifier.size(100.dp, 100.dp)
    )

    Row {
        Text(text = "最高${weather.value!!.timelines.daily[0].values.temperatureMax!!.toInt()}℃")
        Text(text = "最底${weather.value!!.timelines.daily[0].values.temperatureMin!!.toInt()}℃")
    }
}

@Composable
fun DayWeather(weather: State<WeatherForecast?>) {
    val cal = weather.value!!.timelines.hourly[0].time.isoToCalendar()
    cal.add(Calendar.DATE,1)
    val hourly = weather.value!!.timelines.hourly.filter {
        val target = it.time.isoToCalendar()
        Log.d("aaa" , "${target > cal}")
        target < cal
    }
    Card(modifier = Modifier.padding(10.dp)) {
        LazyRow {
            items(hourly) { item ->
                Column(
                    modifier = Modifier
                        .width(70.dp)
                        .padding(5.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    val weatherCode =
                        WeatherCode.fromCode(item.values.weatherCode)!!
                    val cal = item.time.isoToCalendar()
                    Text(text = "${cal.get(Calendar.HOUR_OF_DAY)}時")
                    Image(
                        painter = painterResource(id = weatherCode.iconResId),
                        contentDescription = weatherCode.toString(),
                        modifier = Modifier.size(30.dp, 30.dp)
                    )

                    Text(text = "${item.values.temperature!!.toInt()}℃")

                }
            }
        }
    }
}


@Composable
fun WeeklyWeather(weather: State<WeatherForecast?>) {
    val daily = weather.value!!.timelines.daily
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .height(300.dp)
    ) {
        LazyColumn {
            items(daily) {
                val weatherCode =
                    WeatherCode.fromCode(it.values.weatherCodeMax)!!
                val cal = it.time.isoToCalendar()
                Row(
                    modifier = Modifier
                        .height(70.dp)
                        .padding(5.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = cal.getJPDayOfWeek())
                    Image(
                        painter = painterResource(id = weatherCode.iconResId),
                        contentDescription = weatherCode.toString(),
                        modifier = Modifier.size(30.dp, 30.dp)
                    )
                    Text(text = "${it.values.temperatureMin!!.toInt()}")
                    Text(text = "${it.values.temperatureMax!!.toInt()}")
                }
            }

        }
    }
}

@Composable
fun OtherInformation() {

}