package kot3.anonimClass10

fun main() {
    val car: Transport = Car("Мустанг")
    val cycle: Transport = Cycle("Bergamot")
    if (car is Car) {
        car.name = "Феррари"
    }

    if (car is Car && car.startEngine()){}

    println(car.name)
    travel(object:Transport("Автобус") {
        override fun drive() {
            println("Автобус едет")
        }
    })
}

fun travel(transport: Transport) {
    transport.drive()
}