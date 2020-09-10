package kot3.inheritance8

open class Animal(val name:String, var weight:Float, val habitat:String) {
   open fun eat() { print("Кушаю")}
    fun run() = println("Бегу")
}