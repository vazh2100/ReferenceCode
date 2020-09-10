package kot

var list:MutableList<Int>? = mutableListOf()

fun main() {

    with(list){
        this?.let{
            for (i in 0 until 1000){add((Math.random()*1000).toInt())
            }
        for (i in this.take(100)){
            println(i)
        }
        }
    }

}