package kot3.singleton14

import javax.xml.crypto.Data

fun main() {
    val db = Database.getInstance()
    db.insert("1")
    db.insert("2")

    for(str in db.data){
        println(str)
    }
}