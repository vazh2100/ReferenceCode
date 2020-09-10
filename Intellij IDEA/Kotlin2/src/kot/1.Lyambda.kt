package kot

//val sum = {a:Int,b:Int -> a+b}
val sum:(Int,Int) -> Int = {a, b -> a+b}

//val square:(Int) -> Int = {a -> a*a}
val square:(Int) -> Int = {it*it}

val perimetr:(Int,Int) -> Int = {a, b -> a*2 + b*2}

//val helloName:(String) ->Unit = { name -> println("Привет, $name!")}
val helloName:(String) ->Unit = { println("Привет, $it!")}

val sortedArray:(Array<Int>) ->Array<Int> = {array -> array.sortedArrayDescending()}

fun main() {
    println(sum(2,10))
    println(square(10))
    println(perimetr(10,20))
    helloName("Андрей")
    val sortedArray = sortedArray(arrayOf(6,5,4,6,7,8))
    for (i in sortedArray){
        println(i)
    }



}