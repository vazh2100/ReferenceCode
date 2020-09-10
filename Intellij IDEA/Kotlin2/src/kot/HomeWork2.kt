package kot

fun main() {

    val array = mutableListOf<Int>()
    for (i in 0 until 1000){
        array.add((Math.random()*1000).toInt())
    }
    for (i in array){
        println(i)
    }

    println("------------------------------")
    val newArray = array.filter { it%5 == 0 || it%3 ==0 }.map{it*it}.sortedDescending().map{"Число $it"}

    for (i in newArray){
        println(i)
    }
}


