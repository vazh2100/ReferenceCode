package kot3.homework6

class Adress(val city:String, val street:String, val number:Int) {


    operator fun component1() = city
    operator fun component2() = street
    operator fun component3() = number

    fun copy(city: String = this.city, street: String = this.street, number: Int = this.number):Adress{
        return Adress(city, street,number)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Adress

        if (city != other.city) return false
        if (street != other.street) return false
        if (number != other.number) return false

        return true
    }

    override fun hashCode(): Int {
        var result = city.hashCode()
        result = 31 * result + street.hashCode()
        result = 31 * result + number
        return result
    }

    override fun toString(): String {
        return "Adress(city='$city', street='$street', number=$number)"
    }


}