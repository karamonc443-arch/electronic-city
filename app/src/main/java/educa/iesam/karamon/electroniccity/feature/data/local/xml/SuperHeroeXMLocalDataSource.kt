package educa.iesam.karamon.electroniccity.feature.data.local.xml

import android.content.Context
import android.content.SharedPreferences
import educa.iesam.karamon.electroniccity.R
import educa.iesam.karamon.electroniccity.core.cache.SuperHeroeAppCache
import educa.iesam.karamon.electroniccity.core.serialization.SuperHeroeJsonSerialization
import educa.iesam.karamon.electroniccity.feature.domain.SuperHeroe

class SuperHeroeXMLocalDataSource(
    private val context: Context,
    private val serialization: SuperHeroeJsonSerialization<List<SuperHeroe>>,
    private val superHeroeAppCahe: SuperHeroeAppCache
) {

    private val keySuperheroe = "superhero"
    private val timeToLive = 5 * 60 * 1000L

    val sharedPref: SharedPreferences = context.getSharedPreferences(
        context.getString(R.string.xml_local_superhero),
        Context.MODE_PRIVATE
    )

    // Guardar una lista completa
    fun save(superHeroes: List<SuperHeroe>) {
        sharedPref.edit().apply {
            putString(keySuperheroe, serialization.toJson(superHeroes))
            apply()
        }
    }

    // Agregar un superhéroe
    fun save(superHeroe: SuperHeroe) {
        val superHeroes = findAll().toMutableList()
        superHeroes.add(superHeroe)
        save(superHeroes)
    }

    // Recuperar todos los superhéroes
    fun findAll(): List<SuperHeroe> {
        val listSuperHero = sharedPref.getString(keySuperheroe, null)

        if (listSuperHero != null) {
            return serialization.fromJson(listSuperHero)
        } else {
            println("La lista está vacía")
            return emptyList()
        }
    }

    // Buscar por ID
    fun findById(id: String): SuperHeroe? {
        return findAll().find { it.id == id }
    }

    // Eliminar por ID
    fun deleteById(id: String) {
        save(findAll().filter { it.id != id })
    }

    // Eliminar todos
    fun deleteAll() {
        sharedPref.edit().apply {
            remove(keySuperheroe)
            apply()
        }
    }

    // Actualizar un superhéroe
    fun update(superHeroe: SuperHeroe) {
        val superHeroes = findAll().filterNot { it.id == superHeroe.id }.toMutableList()

        superHeroes.add(superHeroe)
        save(superHeroes)
    }
}
