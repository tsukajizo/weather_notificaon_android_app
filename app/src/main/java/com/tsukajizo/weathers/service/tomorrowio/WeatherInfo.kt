package com.tsukajizo.weathers.service.tomorrowio

class HourlyValue(
    val cloudBase: Double?,
    val cloudCeiling: Double?,
    val cloudCover: Double?,
    val dewPoint: Double?,
    val freezingRainIntensity: Double?,
    val humidity: Double?,
    val precipitationProbability: Double?,
    val pressureSurfaceLevel: Double?,
    val rainIntensity: Double?,
    val sleetIntensity: Double?,
    val snowIntensity: Double?,
    val temperature: Double?,
    val temperatureApparent: Double?,
    val uvHealthConcern: Double?,
    val uvIndex: Double?,
    val visibility: Double?,
    val weatherCode: Double?,
    val windDirection: Double?,
    val windGust: Double?,
    val windSpeed: Double?,
)

class MinutelyValue(
    val cloudBase: Double?,
    val cloudCeiling: Double?,
    val cloudCover: Double?,
    val dewPoint: Double?,
    val freezingRainIntensity: Double?,
    val humidity: Double?,
    val precipitationProbability: Double?,
    val pressureSurfaceLevel: Double?,
    val rainIntensity: Double?,
    val sleetIntensity: Double?,
    val snowIntensity: Double?,
    val temperature: Double?,
    val temperatureApparent: Double?,
    val uvHealthConcern: Double?,
    val uvIndex: Double?,
    val visibility: Double?,
    val weatherCode: Double?,
    val windDirection: Double?,
    val windGust: Double?,
    val windSpeed: Double?,
)

data class DailyValue(
    val cloudBaseAvg: Double?,
    val cloudBaseMax: Double?,
    val cloudBaseMin: Double?,
    val cloudCeilingAvg: Double?,
    val cloudCeilingMax: Double?,
    val cloudCeilingMin: Double?,
    val cloudCoverAvg: Double?,
    val cloudCoverMax: Double?,
    val cloudCoverMin: Double?,
    val dewPointAvg: Double?,
    val dewPointMax: Double?,
    val dewPointMin: Double?,
    val evapotranspirationAvg: Double?,
    val evapotranspirationMax: Double?,
    val evapotranspirationMin: Double?,
    val evapotranspirationSum: Double?,
    val freezingRainIntensityAvg: Double?,
    val freezingRainIntensityMax: Double?,
    val freezingRainIntensityMin: Double?,
    val humidityAvg: Double?,
    val humidityMax: Double?,
    val humidityMin: Double?,
    val iceAccumulationAvg: Double?,
    val iceAccumulationLweAvg: Double?,
    val iceAccumulationLweMax: Double?,
    val iceAccumulationLweMin: Double?,
    val iceAccumulationLweSum: Double?,
    val iceAccumulationMax: Double?,
    val iceAccumulationMin: Double?,
    val iceAccumulationSum: Double?,
    val moonriseTime: String?,
    val moonsetTime: String?,
    val precipitationProbabilityAvg: Double?,
    val precipitationProbabilityMax: Double?,
    val precipitationProbabilityMin: Double?,
    val pressureSurfaceLevelAvg: Double?,
    val pressureSurfaceLevelMax: Double?,
    val pressureSurfaceLevelMin: Double?,
    val rainAccumulationAvg: Double?,
    val rainAccumulationLweAvg: Double?,
    val rainAccumulationLweMax: Double?,
    val rainAccumulationLweMin: Double?,
    val rainAccumulationMax: Double?,
    val rainAccumulationMin: Double?,
    val rainAccumulationSum: Double?,
    val rainIntensityAvg: Double?,
    val rainIntensityMax: Double?,
    val rainIntensityMin: Double?,
    val sleetAccumulationAvg: Double?,
    val sleetAccumulationLweAvg: Double?,
    val sleetAccumulationLweMax: Double?,
    val sleetAccumulationLweMin: Double?,
    val sleetAccumulationLweSum: Double?,
    val sleetAccumulationMax: Double?,
    val sleetAccumulationMin: Double?,
    val sleetIntensityAvg: Double?,
    val sleetIntensityMax: Double?,
    val sleetIntensityMin: Double?,
    val snowAccumulationAvg: Double?,
    val snowAccumulationLweAvg: Double?,
    val snowAccumulationLweMax: Double?,
    val snowAccumulationLweMin: Double?,
    val snowAccumulationLweSum: Double?,
    val snowAccumulationMax: Double?,
    val snowAccumulationMin: Double?,
    val snowAccumulationSum: Double?,
    val snowIntensityAvg: Double?,
    val snowIntensityMax: Double?,
    val snowIntensityMin: Double?,
    val sunriseTime: String?,
    val sunsetTime: String?,
    val temperatureApparentAvg: Double?,
    val temperatureApparentMax: Double?,
    val temperatureApparentMin: Double?,
    val temperatureAvg: Double?,
    val temperatureMax: Double?,
    val temperatureMin: Double?,
    val uvHealthConcernAvg: Double?,
    val uvHealthConcernMax: Double?,
    val uvHealthConcernMin: Double?,
    val uvIndexAvg: Double?,
    val uvIndexMax: Double?,
    val uvIndexMin: Double?,
    val visibilityAvg: Double?,
    val visibilityMax: Double?,
    val visibilityMin: Double?,
    val weatherCodeMax: Double?,
    val weatherCodeMin: Double?,
    val windDirectionAvg: Double?,
    val windGustAvg: Double?,
    val windGustMax: Double?,
    val windGustMin: Double?,
    val windSpeedAvg: Double?,
    val windSpeedMax: Double?,
    val windSpeedMin: Double?
)

data class Minutely(
    val time: String,
    val values: MinutelyValue
)

data class Daily(
    val time: String,
    val values: DailyValue
)

data class Hourly(
    val time: String,
    val values: HourlyValue
)


data class Timeline(
    val minutely: List<Minutely>,
    val daily: List<Daily>,
    val hourly: List<Hourly>,
)

data class Location(
    val lat: Double,
    val lon: Double
)

/**
 * com.tsukajizo.weathers.service.open_weather_map
 */
data class WeatherForecast(
    val timelines: Timeline,
    val location: Location
)
