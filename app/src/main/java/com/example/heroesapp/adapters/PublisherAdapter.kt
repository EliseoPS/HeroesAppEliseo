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
import com.example.heroesapp.models.Publisher
import com.squareup.picasso.Picasso

class PublisherAdapter(val publishers : List<Publisher>, val onClick:(Publisher)->Unit)
    : RecyclerView.Adapter<PublisherViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PublisherViewHolder {
        //Layout inflater nos permite inflar (crear) las vistas, la activity en donde estamos sirve como el contecto que le dice que inflar
        //Luego usamos r para encontrar que item vamos a inflar
        val view = LayoutInflater.from(parent.context).inflate(R.layout.publicadora_item, parent, false)
        return PublisherViewHolder(view)
    }

    override fun getItemCount(): Int {
        //contar items o vistas a recyclar
       return publishers.count()
    }

    override fun onBindViewHolder(holder: PublisherViewHolder, position: Int) {
        //Este metodo va a ir elemento por elemento obteniendo sus datos
        val publisher = publishers[position]
        holder.publisherName.text = publisher.name
        Picasso.get().load(publisher.image).into(holder.publisherImage)

        holder.publisherImage.setOnClickListener{
            onClick(publisher)
        }

    }

}
class PublisherViewHolder(view : View) : ViewHolder(view){
    //Indicamos las cualidades de nuestra vista
    //Igualamos cada cosa a view para indicar que va a buscar esos elementos en la vista de Publisher y los busca por su id
    val publisherImage : ImageView = view.findViewById(R.id.publisherImg)
    val publisherName : TextView = view.findViewById(R.id.publisherName)



}

