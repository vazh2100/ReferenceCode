package kot3.dataclass6

fun main() {
    val student1 = Student("Андрей", "Андреевич", "50005")
//    val student2 = Student("Андрей", "Андреевич", "50005")
//    val student2 = student1.copy()
    val student2 = student1.copy(id = "340000")

    val (name, _, id) = student1
    println(name)
//    println(lastName)
    println(id)

    println(student1)
    println(student2)
    println(student1.hashCode())
    println(student2.hashCode())
    println(student1==student2)
    println(student1===student2)
}