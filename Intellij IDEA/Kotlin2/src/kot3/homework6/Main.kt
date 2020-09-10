package kot3.homework6

fun main() {
    val adress1 = Adress("Ростов-на-Дону", "Александровский спуск", 93)
    val adress2 = adress1.copy(number = 94)

    println(adress1.toString())
    println(adress2.toString())
    println(adress1.hashCode())
    println(adress2.hashCode())
    println(adress1==adress2)
    println(adress1===adress2)

    val (city, street, number) = adress1
}