package kot


fun main() {


    val listOfNames = mutableListOf<String>();

    for (i in 0 until 1000){
        if(i%2 == 0){
        listOfNames.add("Андрей")} else{
            listOfNames.add("Василий")
        }
    }

    for (name in listOfNames){
        println(name)
    }

    val listOfPhones = mutableListOf<Long>();

    for (i in 0 until 1000){
        var phone = +79001356000
        listOfPhones.add(phone+i)
    }

    for (phone in listOfPhones){
        println(phone)
    }


    val users = listOfNames.zip(listOfPhones);

    for (user in users){
        println("Имя: ${user.first}\nТелефон: ${user.second}" )
    }



    val namesFamilies = mutableListOf<String>();

    namesFamilies.add("Андрей Важенин")
    namesFamilies.add("Сергей Нор-Аревян")
    namesFamilies.add("Настя Шестопалова")
    namesFamilies.add("Татьяна Богданова")

//    val names = namesFamilies.map{it.substringBefore(" ")}
//    val families = namesFamilies.map{it.substringAfter(" ")}
//    val namesPlusFamilies = names.zip(families)
//
//    for (item in namesPlusFamilies){
//        println(item.first + " " + item.second)
//    }
    val users1 = namesFamilies.map{ Pair(it.substringBefore(" "), it.substringAfter(" "))}


}