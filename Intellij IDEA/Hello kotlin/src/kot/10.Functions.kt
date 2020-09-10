package kot


//Стандартное выражение
//fun max(a: Int, b: Int): Int {
//    if (a > b) {
//        return a
//    } else {
//        return b
//    }
//}

//Сокращённое выражение:
//fun max(a: Int, b: Int): Int {
//    return if (a > b) {
//        a
//    } else {
//        b
//    }
//}

//Ещё более короткая запись
//fun max(a: Int, b: Int): Int = if (a > b) a else b

//ещё более короткая версия
fun max(a: Int, b: Int)= if (a > b) a else b

fun fiveSymbols(string:String) = string.substring(0,Math.min(5, string.length))

fun sum (vararg numbers:Int):Int{
    var result = 0
    for (num in numbers) {
        result += num
    }
    return result
}



fun main() {
    println(max(30, 50))
    println(fiveSymbols("Мистификация"))
    println(sum(2,5,6,8,9))
}

