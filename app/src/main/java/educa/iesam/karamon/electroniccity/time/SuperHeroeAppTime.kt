package educa.iesam.karamon.electroniccity.time

interface SuperHeroeAppTime {
    fun currentTime(): Long

    class SuperHeroeAppLocalTime : SuperHeroeAppTime {
        override fun currentTime(): Long {
            return System.currentTimeMillis()
        }
    }
}