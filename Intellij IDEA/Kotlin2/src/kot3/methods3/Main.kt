package kot3.methods3

fun main() {
    val cat = Cat("Барсик", 12, 3.5f)
    cat.printInfo()
    println(cat.isOld)
    cat.age = 10
    println(cat.isOld)
}

//fun Cat.isOld() = age >=12