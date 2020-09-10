package kot

var name:String? = null

fun main() {
//    if(name?.length?.compareTo(5) == 1) {
//        println("Hello")
//    }

    name?.let{if( it.length>5){
      println("больше")

    } }

//    val list = mutableListOf<Int>()
//    for (i in 0 until 1000){
//        list.add((Math.random()*100).toInt())
//    }
//    for (i in list){
//        println(i)
//    }
//    val sum = list.sum()
//    val max = list.max()
//    val min = list.min()
//    val average = list.average()
//    val first = list[0]
//    val last = list.last()
//    println("max: $max")
//    println("min: $min")
//    println("sum: $sum")
//    println("average: $average")
//    println("first: $first")
//    println("last: $last")


    val list = mutableListOf<Int>()

    with(list) {
        for (i in 0 until 1000){
            add((Math.random()*100).toInt())
        }
        val sum = sum()
        val max = max()
        val min = min()
        val average = average()
        val first = this[0]
        val last = last()
        println("max: $max")
        println("min: $min")
        println("sum: $sum")
        println("average: $average")
        println("first: $first")
        println("last: $last")
    }



    
    
}