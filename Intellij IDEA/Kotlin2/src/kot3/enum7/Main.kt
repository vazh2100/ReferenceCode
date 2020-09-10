package kot3.enum7

import kot3.enum7.Month.*
import kot3.enum7.Season.*
fun main() {
    val month = SEPTEMBER
    val season = when (month) {
        DECEMBER, JANUARY,FEBRUARY -> WINTER
        MARCH, APRIL, MAY -> SPRING
        JUNE, JULY, AUGUST -> SUMMER
        SEPTEMBER, OCTOBER, NOVEMBER -> AUTUMN
    }
    println(season)
    println(month.tempAverage)
}
