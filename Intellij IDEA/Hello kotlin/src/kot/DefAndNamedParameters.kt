package kot

fun main() {
    printInfo(patronymic = "Александрович")

}

fun printInfo(lastname: String = "", name: String = "", patronymic: String = "") {
    if (lastname.isNotEmpty()) {
        println("Фамилия: $lastname")
    }
    if (name.isNotEmpty()) {
        println("Имя: $name")
    }
    if (patronymic.isNotEmpty()) {
        println("Отчество: $patronymic")
    }
}

fun printInfo(lastname: String, name: String) {
    printInfo(lastname, name, "")
}