package educa.iesam.karamon.electroniccity.feature.domain

class GetSuperHeroeUseCase(private val superHeroeRepository: SuperHeroeRepository) {

    operator fun invoke(): List<SuperHeroe> {
        return superHeroeRepository.obtainAll()
    }
}