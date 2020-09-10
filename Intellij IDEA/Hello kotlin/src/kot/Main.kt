package kot
//
//fun main(args: Array<String>) {
//        println("Hello world")
//    }

//fun main() {
//    println("Hello World")
//}

private var name:String? = null;

fun main() {
//    var name = "Иван";
//    var name2:String = "Vasya";
//    name = "Max";
//    var age:Int;
    val length = name?.length?:0;
    println(length);
}
