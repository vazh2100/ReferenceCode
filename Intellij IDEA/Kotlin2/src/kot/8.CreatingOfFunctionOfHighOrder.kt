package kot

fun main() {
    println(modifyString("Hello"){it.toUpperCase()})
    val list = mutableListOf(1,4,56,7,5,3)

    val newList = modifyList(list) {it.add(10); it}

    for (i in newList){ println(i)}


}

fun modifyString(string:String, modify: (String) -> String):String {
    return modify(string)
}

inline fun modifyList(list:MutableList<Int>, modify: (MutableList<Int>) -> MutableList<Int>) : MutableList<Int>{
  return modify(list)
}