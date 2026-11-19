package educa.iesam.karamon.electroniccity.feature.presentation.viewmodels

import androidx.lifecycle.ViewModel
import educa.iesam.karamon.electroniccity.feature.domain.GetSuperHeroeUseCase

class SuperHeroeListViewModel(private val getSuperHeroeUseCase: GetSuperHeroeUseCase) :
    ViewModel() {
    fun getSuperHeroesListViewModel() = getSuperHeroeUseCase.invoke()
}