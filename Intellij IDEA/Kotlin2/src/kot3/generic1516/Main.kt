package kot3.generic1516

fun main() {
//    val list:MyList<Int> = MyArrayList()
    val list = MyArrayList.myListOf(1,2,3,4,5)


    for (i in 0..25){
        list.add(i)
    }

    for (i in 0 until list.size()){
        println(list.get(i))

    }
}