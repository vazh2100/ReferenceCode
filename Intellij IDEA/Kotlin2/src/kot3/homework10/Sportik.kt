package kot3.homework10

class Sportik {

    fun callWaterGetter(wt:WaterGetter){
        wt.giveWater()
    }
    inline fun callWaterGetter(bringWater:() -> Unit) {
        bringWater()
    }
}