package educa.iesam.karamon.electroniccity.feature.data.local.memory

import educa.iesam.karamon.electroniccity.R
import educa.iesam.karamon.electroniccity.feature.domain.SuperHeroe

class SuperHeroeMemoryLocalDataSource {
    private val supherHeroeMemoryLocalDataSource = mutableListOf(
        SuperHeroe(
            "1",
            "Spider-Man",
            "Peter Parker es un joven que obtiene poderes arácnidos tras ser mordido por una araña radiactiva. Utiliza sus habilidades para proteger Nueva York.",
            "spider-man",
            image = R.drawable.spiderman
        ),
        SuperHeroe(
            "2",
            "Black Panther",
            "T'Challa es el rey de Wakanda y protector de su nación. Posee habilidades mejoradas y utiliza un traje de vibranium.",
            "black-panther",
            image = R.drawable.black_panther
        ),
        SuperHeroe(
            "3",
            "Iron Man",
            "Tony Stark es un brillante inventor y empresario que crea una armadura tecnológica avanzada para combatir el crimen.",
            "iron-man",
            image = R.drawable.iron_man
        ),
        SuperHeroe(
            "4",
            "Thor",
            "Thor es el dios del trueno de Asgard. Posee una fuerza extraordinaria y utiliza su poderoso martillo Mjolnir.",
            "thor",
            image = R.drawable.thor
        ),
        SuperHeroe(
            "5",
            "Hulk",
            "Bruce Banner es un científico que se transforma en Hulk cuando se enfada. Tiene una fuerza descomunal y una gran resistencia.",
            "hulk",
            image = R.drawable.hulk
        ),
        SuperHeroe(
            "6",
            "Captain America",
            "Steve Rogers es un supersoldado que lucha por la justicia. Destaca por su fuerza, resistencia y su inseparable escudo.",
            "captain-america",
            image = R.drawable.captain_america
        ),
        SuperHeroe(
            "7",
            "Superman",
            "Clark Kent es un héroe procedente del planeta Krypton. Tiene super fuerza, capacidad de volar, visión calorífica y gran resistencia.",
            "superman",
            image = R.drawable.superman
        ),
        SuperHeroe(
            "8",
            "Batman",
            "Bruce Wayne es un millonario que combate el crimen en Gotham City utilizando su inteligencia, entrenamiento y tecnología avanzada.",
            "batman",
            image = R.drawable.batman
        ),
        SuperHeroe(
            "9",
            "Wonder Woman",
            "Diana Prince es una princesa amazona con fuerza sobrehumana, habilidades de combate y un gran sentido de la justicia.",
            "wonder-woman",
            image = R.drawable.wonder_woman
        ),
        SuperHeroe(
            "10",
            "Flash",
            "Barry Allen es un superhéroe capaz de correr a velocidades extraordinarias gracias a su conexión con la Fuerza de la Velocidad.",
            "flash",
            image = R.drawable.flash
        )
    )

    fun getAllSuperHeroesMemoryLocalDataSource() = supherHeroeMemoryLocalDataSource

    fun deleteByIdSupHeroeMemoryLocalDataSource(id: String) {
        supherHeroeMemoryLocalDataSource.find { it.id == id }
    }

    fun deleteAllSupHeroeMemoryLocalDataSource(superHeroes: List<SuperHeroe>) {
        supherHeroeMemoryLocalDataSource.removeAll { true }
    }

    fun findByIdSuperHeroeMemoryLocalDataSource(id: String): SuperHeroe? {
        return supherHeroeMemoryLocalDataSource.find { it.id == id }
    }

    fun updateByIdSuperHeroeMemoryLocalDataSource(id: String, superHeroe: SuperHeroe) {
        val superHeroeIndex = supherHeroeMemoryLocalDataSource.indexOfFirst { it.id == id }
        if (superHeroeIndex != -1) {
            supherHeroeMemoryLocalDataSource[superHeroeIndex] = superHeroe
        }
    }
}