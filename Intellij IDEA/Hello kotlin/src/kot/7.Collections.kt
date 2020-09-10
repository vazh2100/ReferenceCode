package kot

val array: Array<Int?> = arrayOf(1,2,3,5,6,7, null);
fun main() {
    array[4] = 10;
    println(array[4])

//    var arrayListOfNumbers:MutableList<Int> = ArrayList();
    var arrayListOfNumbers:MutableList<Int> = mutableListOf();
    arrayListOfNumbers.add(5)
    println(arrayListOfNumbers[0])
}