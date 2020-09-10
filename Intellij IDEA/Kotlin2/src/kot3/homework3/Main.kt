package kot3.homework3

fun main() {
    val worker = Worker("Андрей", "Программист", 2020)
    worker.printInfo()

}

fun Worker.printInfo() = println("Имя: $name Позиция: $position Год устройства на работу:$year Стаж: $stazh")