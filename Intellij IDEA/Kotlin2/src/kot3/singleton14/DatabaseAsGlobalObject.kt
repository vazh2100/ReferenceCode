package kot3.singleton14

object DatabaseAsGlobalObject  {
        val name = "main.db"
        val version = 1
        val data = mutableListOf<String>()

        fun insert(str: String) {
            data.add(str)
        }


        }
