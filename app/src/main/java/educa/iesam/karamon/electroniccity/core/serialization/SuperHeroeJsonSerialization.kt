package educa.iesam.karamon.electroniccity.core.serialization

interface SuperHeroeJsonSerialization<T> {
    fun toJson(obj: T): String
    fun fromJson(string: String): T
}