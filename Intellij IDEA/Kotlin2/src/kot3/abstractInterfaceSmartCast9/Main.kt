package kot3.abstractInterfaceSmartCast9

fun main() {
    val array:MutableList<Worker> = mutableListOf()
    val worker:Worker = Seller("Андрей", 25)
    val programmer:Programmer = Programmer("Сергей", 15, "Kotlin, Java")
    array.add(worker)
    array.add(programmer)
    array.add(Director("Андрей Александрович", 25))
    for (worker in array){
        worker.work()
        if (worker is Cleaner){
            worker.clean()
        }

        if (worker is Programmer){
            println(worker.programLang)
        }

//    явное приведение типов     worker as Cleaner
    }

    val cleaners = array.filter { it is Cleaner }.map { it as Cleaner }

    for (cleaner in cleaners) {
        cleaner.clean()
    }

}