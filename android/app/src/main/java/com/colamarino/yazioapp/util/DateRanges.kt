
package com.colamarino.yazioapp.util

import java.time.LocalDate
import java.time.format.DateTimeFormatter

enum class TimeRange { DAY, WEEK, MONTH, YEAR }

fun rangeDates(range: TimeRange): Pair<String,String> {
    val fmt = DateTimeFormatter.ISO_DATE
    val end = LocalDate.now()
    val start = when(range){
        TimeRange.DAY -> end
        TimeRange.WEEK -> end.minusDays(6)
        TimeRange.MONTH -> end.minusDays(29)
        TimeRange.YEAR -> end.minusDays(364)
    }
    return fmt.format(start) to fmt.format(end)
}
