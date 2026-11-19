package educa.iesam.karamon.electroniccity.feature.domain

interface SuperHeroeRepository {

    fun obtainAll(): List<SuperHeroe>

    fun updateById(id: String, superHeroe: SuperHeroe)

    fun findById(id: String): SuperHeroe?

    fun deleteById(id: String)

    fun deleteAll()
}
