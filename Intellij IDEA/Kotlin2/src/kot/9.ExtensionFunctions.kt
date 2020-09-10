package kot

fun main() {
    val age = 5


    if (age.isAgeValid()) {
        println("Valid")
    }
    if (age.isAgeValid()) {
        println("Valid")
    }
    if (age.isAgeValid()) {
        println("Valid")
    }
    if (age.isAgeValid()) {
        println("Valid")
    }

    val name = ""
    if (name.isNotEmpty()) {
        println("Строка не пустая")
    }

    val age2 = 7


    println(age2.isWhole())


    val list = listOf<Int>()
    myWith(list){
        sum()
    }

    val string = "String;"
    myWith(string) {
        println(toUpperCase())
    }

}

//fun isAgeValid(age:Int) = age in 12..100

fun Int.isAgeValid() = this in 12..100

fun Int.isPositive() = this >= 0


fun Int.isWhole(): Boolean {
    if (this <= 3) return true
    for (i in 2 until this) {
        if (this % i == 0) return false
    }
    return true
}


fun myWith (list:List<Int>, operation: List<Int>. () -> Unit){
    list.operation()
}

fun myWith (string:String, operation: String.() -> Unit){
    string.operation()
}

//fun myWith (obj:Any, operation: Any.() -> Unit){
//    obj.operation()
//}

inline fun<T, R> myWith (obj:T, operation: T.() -> R):R {
    return obj.operation()
}