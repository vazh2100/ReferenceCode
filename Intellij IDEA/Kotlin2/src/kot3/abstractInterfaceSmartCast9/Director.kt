package kot3.abstractInterfaceSmartCast9

class Director(name:String, age:Int):Worker(name, age) {
    override fun work() {
        println("Управляю процессом")
    }
}