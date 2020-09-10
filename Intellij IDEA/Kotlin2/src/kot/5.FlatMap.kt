package kot

fun main() {
    val revenueOfWeek = listOf(
        listOf(470000, 500000, 600000, 200000, 150000, 300000),
        listOf(430000, 500000, 600000, 200000, 150000, 300000),
        listOf(460000, 500000, 600000, 200000, 150000, 300000),
        listOf(490000, 500000, 600000, 200000, 150000, 300000),
        listOf(410000, 500000, 600000, 200000, 150000, 300000)
    )

//    val total = mutableListOf<Int>()
//    revenueOfWeek.map {
//        for (i in it){
//            total.add(i)
//        }
//    }
//Делает тоже самое что и в закомментированном коде
    val total = revenueOfWeek.flatMap { it }
    val average = total.average()
    println(average)

//    val data = mutableMapOf<String, List<Int>>()
//    data.put("Key1", listOf(1,5,6,8))
//    data.put("Key2", listOf(1,6,6,9))
//    data["Key3"] = listOf(1,5,7,8)

//    val data = mapOf<String, List<Int>>
    val data = mapOf (
        "Key1" to listOf(1, 5, 6, 8),
        "Key2" to listOf(1, -6, 6, 9),
        "Key3" to listOf(1, 5, 7, 8)
    )
//аналогичный способ
//    val data = mapOf (
//       Pair( "Key1", listOf(1, 5, 6, 8)),
//       Pair( "Key2", listOf(1, 6, 6, 9)),
//       Pair ("Key3", listOf(1, 5, 7, 8)))

//    val average2 = data.flatMap{it.value}.average()
//    val average2 = data.filter { it.value.all { it>=0 } }.flatMap { it.value }.average()
//    аналогичная закпись:
    val average2 = data.filterNot { it.value.any { it<0 } }.flatMap { it.value }.average()


    println(average2)
}