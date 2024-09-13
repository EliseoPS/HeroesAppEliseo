package com.example.heroesapp.adapters
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.heroesapp.R
import com.example.heroesapp.models.Hero
import com.squareup.picasso.Picasso

class HeroAdapter(val heroes : List<Hero>)
    : RecyclerView.Adapter<HeroViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        //Layout inflater nos permite inflar (crear) las vistas, la activity en donde estamos sirve como el contecto que le dice que inflar
        //Luego usamos r para encontrar que item vamos a inflar
        val view = LayoutInflater.from(parent.context).inflate(R.layout.hero_item, parent, false)
        return HeroViewHolder(view)
    }

    override fun getItemCount(): Int {
        //contar items o vistas a recyclar
        return heroes.count()
    }

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        //Este metodo va a ir elemento por elemento obteniendo sus datos
        //Busca y almacena cada dato del objeto Hero
        val hero = heroes[position]
        holder.heroName.text = hero.name
        Picasso.get().load(hero.image).into(holder.heroImage)
        holder.heroDescription.text = hero.description

    }

}
class HeroViewHolder(view : View) : ViewHolder(view){
    //Indicamos las cualidades de nuestra vista
    //Igualamos cada cosa a view para indicar que va a buscar esos elementos en la vista de Publisher y los busca por su id
    val heroImage : ImageView = view.findViewById(R.id.heroImg)
    val heroName : TextView = view.findViewById(R.id.heroName)
    val heroDescription : TextView = view.findViewById(R.id.heroDescription)

}


