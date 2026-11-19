package educa.iesam.karamon.electroniccity

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import educa.iesam.karamon.electroniccity.feature.data.SuperHeroeDataRepository
import educa.iesam.karamon.electroniccity.feature.data.local.memory.SuperHeroeMemoryLocalDataSource
import educa.iesam.karamon.electroniccity.feature.domain.GetSuperHeroeUseCase
import educa.iesam.karamon.electroniccity.feature.presentation.viewmodels.SuperHeroeListViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val superHeroeListViewModel = SuperHeroeListViewModel(
            GetSuperHeroeUseCase(
                SuperHeroeDataRepository(
                    SuperHeroeMemoryLocalDataSource()
                )
            )
        )

        val listSuperHeroesViewModels = superHeroeListViewModel.getSuperHeroesListViewModel()

        val superHeroes = findViewById<LinearLayout>(R.id.andRvListItems)

        listSuperHeroesViewModels.forEach { superHeroe ->

            // Inflamos el XML de cada tarjeta
            val view = LayoutInflater.from(this)
                .inflate(R.layout.list_items, superHeroes, false)

            // Recuperamos los elementos visuales
            val imageView = view.findViewById<ImageView>(R.id.imageView)

            val txtName = view.findViewById<TextView>(R.id.txtName)

            val txtDescription = view.findViewById<TextView>(R.id.txtDescription)

            val txtSlug = view.findViewById<TextView>(R.id.txtSlug)

            // Introducimos los datos
            txtName.text = superHeroe.name
            txtDescription.text = superHeroe.description
            txtSlug.text = superHeroe.slug

            // Asignamos la imagen local
            imageView.setImageResource(superHeroe.image)

            // Añadimos la tarjeta al LinearLayout
            superHeroes.addView(view)
        }
    }
}
