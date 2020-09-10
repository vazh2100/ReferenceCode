package kot

fun main() {
//    val array = arrayOf(1,2,3,4,5,6,7,7,7,7)
//    for(i in array){
//        println(i)
//    }

//    val array = arrayOfNulls<Int?>(101)
//    for(i in 0 until array.size){
//        array[i] = i;
//    }
//    val array = arrayOfNulls<Int?>(101)
//    for(i in 100 downTo 0 step 2){
//        array[i] = i;
//    }
//    for (i in array){
//        println(i)
//    }


//    val array = arrayOf(0..100);

    val array = arrayOfNulls<Int>(101);
    for (i in 0..100){
        array[i] = i;
    }

    for ((index, i) in array.withIndex()){
        array[index] = i?.times(2);
    }

    for (i in array){
        println(i)
    }


}
