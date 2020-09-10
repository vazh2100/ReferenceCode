package kot3.HomeWork8

fun main() {
    val array:MutableList<Worker> = mutableListOf()
    val worker:Worker = Worker("Андрей", 25)
    val programmer:Programmer = Programmer("Сергей", 15, "Kotlin, Java")
    array.add(worker)
    array.add(programmer)
    for (worker in array){
        worker.work()
    }
}