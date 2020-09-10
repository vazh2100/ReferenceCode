package kot

fun main() {
    val employees = generateSequence(0){it+1}.map{"Сотрудник $it"}
    val emp = employees.take(10)
    for (emp in emp){
        println(emp)
    }
}