package com.tsukajizo.weathers.utils

import java.text.SimpleDateFormat
import java.util.Calendar

fun Calendar.getJPDayOfWeek(): String {
    when (get(Calendar.DAY_OF_WEEK)) {
        Calendar.SUNDAY -> return "日"
        Calendar.MONDAY -> return "月"
        Calendar.TUESDAY -> return "火"
        Calendar.WEDNESDAY -> return "水"
        Calendar.THURSDAY -> return "木"
        Calendar.FRIDAY -> return "金"
        Calendar.SATURDAY -> return "土"
    }
    throw IllegalStateException()
}

fun Calendar.toDateString():String{
    val format = SimpleDateFormat("yyyy/mm/dd HH:MM:SS")
    return format.format(this.time)
}

fun Calendar.toDayOfMonthString():String{
    val format = SimpleDateFormat("mm/dd")
    return format.format(this.time)
}

fun String.isoToCalendar():Calendar{
    val cal = Calendar.getInstance()
    val format = SimpleDateFormat("yyyy-mm-dd'T'HH:MM:SSX")
    cal.time = format.parse(this)
    return cal
}
