package kot

val a = 60;


fun main() {
//    if (a<40){
//        println("меньше 40")
//    } else if (a>40&&a<60){
//        println("больше 40, но меньше 60")}
//    else{
//        println("больше 60") }
    val money = 400;
    var food = if (money>500){
       "Пицца";
    } else if (money>200) {
       "Shaurma";
    }else{"Doshirak";}

    println("Vi mozhete pozvolit' sebe ${food.length}");
}