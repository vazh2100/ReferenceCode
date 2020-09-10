package kot

fun main() {
    val array = (0..1000).toList();
    val employees = array.map{"Сотрудник $it"};
//    val first30 = employees.take(30);
    val first30 = employees.drop(30);
    for (employee in first30){
        println(employee)
    }

    val array2 = generateSequence(0){ it + 2}
    val evenNumbers = array2.take(10)

    val array3 = generateSequence{(Math.random()*1000).toInt()}

    for (i in array3.take(10)) {
        println(i)
    }


}