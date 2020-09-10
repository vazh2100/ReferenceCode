package kot3.HomeWork8


class Programmer(name:String, age:Int,  val programLang:String): Worker(name, age) {

    override fun work() {
        println("Пишу код на $programLang")
    }
}