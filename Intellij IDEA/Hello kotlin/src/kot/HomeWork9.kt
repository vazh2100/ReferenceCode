package kot

fun main() {
    val array = arrayOfNulls<Int?>(301)
    for((index, i) in (300..600).withIndex()){
        array[index] = i
    }

    for (i:Int in array.size - 1 downTo 0 step 5){
        println(array[i])
    }


}

