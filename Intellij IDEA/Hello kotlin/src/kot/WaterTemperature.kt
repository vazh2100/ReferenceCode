package kot

fun main() {
    val temper: Int = 0;
    var waterState: String = if (temper > 100) {
        "Пар"
    } else if (temper > 0) {
        "Вода"
    } else {
        "Лёд"
    }

    waterState = when {
        temper > 100 || 2 < 10 -> "Пар"
        temper in 0..100 -> "Вода"
        else -> "Лёд"
    }

    println(waterState)
}