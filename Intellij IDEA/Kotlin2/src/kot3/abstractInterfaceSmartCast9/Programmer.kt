package kot3.abstractInterfaceSmartCast9


class Programmer(name:String, age:Int,  val programLang:String): Worker(name, age), Cleaner {

    override fun work() {
        println("Пишу код на $programLang")
    }

    override fun clean() {
        println("Навожу порядок в компьютере")
    }
}