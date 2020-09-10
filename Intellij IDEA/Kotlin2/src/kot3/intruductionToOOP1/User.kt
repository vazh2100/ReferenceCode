package kot3.intruductionToOOP1

class User {

  var age:Int = 0
    set(value) {if (value>=0){field = value}}
  var name:String? = null
    get() { return if(field == null) {""} else {field}}


//    fun setAge(age:Int){
//        this.age = age
//    }
//
//    fun getAge() = age
//
//
//    fun setName(name:String){
//        this.name = name
//    }
//
//    fun getName() = name

}