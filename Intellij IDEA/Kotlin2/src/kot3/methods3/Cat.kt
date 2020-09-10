package kot3.methods3

class Cat(val name:String, var age:Int, val weight:Float = 0f) {
//    свойство
    val isOld
        get() = age>=12

    fun printInfo(){
        println("Имя: $name Возраст: $age Вес: $weight")
    }

//    fun isOld():Boolean {
//        if(age>=12){return true}
//        return false
//    }

//    fun isOld() = age>=12
}