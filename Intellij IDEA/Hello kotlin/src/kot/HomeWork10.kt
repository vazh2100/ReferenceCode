package kot

fun main() {
val numbers = mutableListOf<Int>(5,-2,10,13,78,3)
    val result = sort(numbers)
    println(result)
}

fun sort (numbers:MutableList<Int>) :List<Int> {
    for(i in 1 until numbers.size){
        for(j in numbers.size-1 downTo i){
            if(numbers[j] < numbers[j-1]){
                val temp:Int = numbers[j]
                numbers[j] = numbers[j-1]
                numbers[j-1] = temp

            }
        }
    }
    return numbers
}

fun sort (numbers:Array<Int>):List<Int> = sort(numbers.toMutableList())

fun sort (vararg numbers: Int):List<Int> = sort(numbers.toMutableList())

