package kot3.dataclass6

class Student(val name:String, val lastName:String, val id:String) {
    operator fun component1() = name;
    operator fun component2() = lastName;
    operator fun component3() =id;

    fun copy(name:String = this.name, lastName: String= this.lastName, id:String = this.id):Student{
        return Student(name,lastName,id)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Student

        if (name != other.name) return false
        if (lastName != other.lastName) return false
        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + lastName.hashCode()
        result = 31 * result + id.hashCode()
        return result
    }

    override fun toString(): String {
        return "Student(name='$name', lastName='$lastName', id='$id')"
    }


}