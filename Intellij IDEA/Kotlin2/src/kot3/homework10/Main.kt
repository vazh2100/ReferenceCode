package kot3.homework10

fun main() {
    val sportik = Sportik()
    sportik.callWaterGetter(object : WaterGetter {
        override fun giveWater() {
            println("Способный нести воду: несёт воду")
        }
    })
    sportik.callWaterGetter { println("Несёт воду") }


}