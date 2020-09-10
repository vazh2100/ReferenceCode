package kot

fun main() {
    val listOfNumbers = mutableListOf<Int>()
    for(i in 0..99){
        listOfNumbers.add(i)
    }
    val listOfEvenNumbers = listOfNumbers.filter { it%2 == 0  }
//  val listOfEvenNumbers = listOfNumbers.filter ({number:Int -> number%2 == 0  })
    for (i in listOfEvenNumbers){
        println(i)
    }


    val listOfNames = mutableListOf<String>("Андрей", "Василий", "Анатолий", "Григорий")
//    val listOfANames = listOfNames.filter { it.substring(0, 1) == "А" }
    val listOfANames = listOfNames.filter { it.startsWith("А") }
    for (i in listOfANames){
        println(i)
    }


    val numbers = (0..100).toList();
//    val doubledNumbers =numbers.map{number:Int -> number*2}
    val doubledNumbers =numbers.map{it*2}
    for (i in doubledNumbers) {
        println(i)
    }
    val employees = numbers.map{"Employee #$it"}

    for (employee in employees){
        println(employee)
    }




    val array = arrayOf(2,5,4,6,2,-5,-6)
//    val sortedArray = array.sorted()
    val sortedArray = array.sortedDescending()

    for (i in sortedArray){
        println(i)
    }



}