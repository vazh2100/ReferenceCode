package kot3.homework13

class MyRandom {

    companion object {
        fun randomize(from: Int, to: Int): Int {
            return (Math.random() * (to - from + 1) + from).toInt()
        }

        fun randomize(): Boolean {
            return Math.random() > 0.5
        }

        fun randomDayOfWeek(): String {
            val index = randomize(1, 7)
            return when (index) {
                1 -> "Понедельник"
                2 -> "Вторник"
                3 -> "Среда"
                4 -> "Четверг"
                5 -> "Пятница"
                6 -> "Суббота"
                7 -> "Воскресенье"
                else -> "День не существует"
            }
        }


    }
}