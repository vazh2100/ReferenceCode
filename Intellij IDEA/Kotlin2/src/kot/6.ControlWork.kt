package kot

fun main() {

val data = mapOf(
    "Январь" to listOf(100,100,100,100),
    "Февраль" to listOf(200,200,-190,200),
    "Март" to listOf(300,180,300,100),
    "Апрель" to listOf(250, -250,100,  300),
    "Май" to listOf(200,100,400,300),
    "Июнь" to listOf(200,100,300,300))

fun data(data:Map<String, List<Int>>):Unit {
    val correctData = data.filter { it.value.all { it>=0}}
    val averageRevenueOfWeek = correctData.flatMap { it.value }.average()
    println("Средняя выручка за неделю: $averageRevenueOfWeek")

    val revenueOfMonth = correctData.map {it.value.sum()}
    val maxSum = revenueOfMonth.max()
    val minSum = revenueOfMonth.min()
    val averageRevenueOfMonth = revenueOfMonth.average()
    val maxMonths = correctData.filter { it.value.sum() == maxSum }.keys
    val minMonth = correctData.filter { it.value.sum() == minSum }.keys

    println("Средняя выручка в месяц: $averageRevenueOfMonth")
    println("Максимальная выручка в месяце $maxMonths - $maxSum")
    println("Минимальная выручка в месяце $minMonth - $minSum")

    val incorrectData = data.filter { it.value.any { it<0}}
    val incorrectMonth = incorrectData.keys
    println("Ошибки данных в следующих месяцах: $incorrectMonth")

}
    data(data);

}