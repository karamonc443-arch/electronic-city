package educa.iesam.karamon.electroniccity.feature.data

import educa.iesam.karamon.electroniccity.feature.data.local.memory.SuperHeroeMemoryLocalDataSource
import educa.iesam.karamon.electroniccity.feature.domain.SuperHeroe
import educa.iesam.karamon.electroniccity.feature.domain.SuperHeroeRepository

class SuperHeroeDataRepository(private val localDataSource: SuperHeroeMemoryLocalDataSource) :
    SuperHeroeRepository {
    override fun obtainAll(): List<SuperHeroe> {
        return localDataSource.getAllSuperHeroesMemoryLocalDataSource()
    }

    override fun updateById(id: String, superHeroe: SuperHeroe) {
        localDataSource.updateByIdSuperHeroeMemoryLocalDataSource(id, superHeroe)
    }

    override fun findById(id: String): SuperHeroe? {
        return localDataSource.findByIdSuperHeroeMemoryLocalDataSource(id)
    }

    override fun deleteById(id: String) {
        localDataSource.deleteByIdSupHeroeMemoryLocalDataSource(id)
    }

    override fun deleteAll() {
        localDataSource.deleteAllSupHeroeMemoryLocalDataSource(
            localDataSource.getAllSuperHeroesMemoryLocalDataSource()
        )
    }

}