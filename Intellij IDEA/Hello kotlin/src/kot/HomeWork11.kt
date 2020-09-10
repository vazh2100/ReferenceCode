package kot

fun main() {

    println( volume(10))
}

fun volume(lenght:Int, width:Int = lenght, height:Int = lenght):Int = lenght*width*height