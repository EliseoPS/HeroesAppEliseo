package com.example.heroesapp.ui

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.heroesapp.MainActivity
import com.example.heroesapp.R
import com.example.heroesapp.adapters.HeroAdapter
import com.example.heroesapp.adapters.PublisherAdapter
import com.example.heroesapp.models.Hero
import com.example.heroesapp.models.Publisher

class HerosActivity : AppCompatActivity() {

    lateinit var heroRecyclerView: RecyclerView
    lateinit var salirBtn : ImageView
    lateinit var txtHeroesDe: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_heros)

        val publisherID = intent.getIntExtra("publisherID",0)
        val publisher = Publisher.publishers.firstOrNull() {it.id == publisherID}
        //Esto es para mostrar solo los heroes con el id de la publicadora sobre la que hicimos click
        val heroes = Hero.heroes.filter { it.publisherId == publisherID }
        val publisherName = intent.getStringExtra("publisherName") ?: "Publisher"
        //Declaramos el recycler view de los hereos
        heroRecyclerView = findViewById(R.id.heroesRecyclerview)

        //variables para poder escribir la descripcion
        txtHeroesDe = findViewById(R.id.txtHeroesDe)
        //Con esto se escribe en el textview de la barra el npmbre de la publicadora sobre la que se hace click
        txtHeroesDe.text = "Heroes de: $publisherName"


        heroRecyclerView.adapter = HeroAdapter(heroes)
        //Para elegir de que manera (vertical, horiz. etc) queremos mostrar los recyclerview
        heroRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)

        salirBtn = findViewById(R.id.atrasBtn)
//boton para salir de la activity
        salirBtn.setOnClickListener{
            val intent = Intent(this@HerosActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}