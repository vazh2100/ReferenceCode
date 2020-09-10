package kot

fun main() {
    val hour:Int = 10;
    val isGoodWeather:Boolean = true;
    val action = when {
        hour in 2..22 && isGoodWeather -> "Гулять";
        hour in 2..22 && !isGoodWeather -> "Читать книгу";
        else -> "Спать";
    }
    println(action)
}