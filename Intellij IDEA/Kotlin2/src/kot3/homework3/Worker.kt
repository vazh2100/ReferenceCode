package kot3.homework3

import java.time.Year
import java.util.*

class Worker(val name:String, val position:String, val year:Int) {
    val stazh:Int
    get() = Calendar.getInstance().get(Calendar.YEAR) - year

    fun work() = println("Работаю")
}