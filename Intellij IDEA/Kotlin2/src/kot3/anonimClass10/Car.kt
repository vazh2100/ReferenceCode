package kot3.anonimClass10

class Car(override var name:String = "Машина"):Transport(name) {
    override fun drive() {
        println("Машина едет")
    }

    fun startEngine():Boolean{
        return true
    }
}