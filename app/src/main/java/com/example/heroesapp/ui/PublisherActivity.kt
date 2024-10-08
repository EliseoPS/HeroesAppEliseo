package com.example.heroesapp.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
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
import com.example.heroesapp.adapters.PublisherAdapter
import com.example.heroesapp.models.Publisher

class PublisherActivity : AppCompatActivity() {
    lateinit var username : TextView
    lateinit var logoutBtn : ImageView



    lateinit var publisherRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_publisher)


        val sharedPreferences = getSharedPreferences("mypref", MODE_PRIVATE)
        val userName = sharedPreferences.getString("userName", "Usuario")
//Variables necesarias para poner el nombre del usuario loggeado
        username = findViewById(R.id.usernameTV)
        username.text = "Hola $userName"


        //para poder referenciar a nuestro recycler view
        publisherRecyclerView = findViewById(R.id.publishersRecyclerview)

        //f
        publisherRecyclerView.adapter = PublisherAdapter(Publisher.publishers){
            publisher ->
            val intent = Intent(this@PublisherActivity, HerosActivity::class.java).apply {
                putExtra("publisherID", publisher.id)
                putExtra("publisherName", publisher.name)
                //Guardamos el nombre y ID de cada publicadora
            }
            Log.i("Navegacion",publisher.toString())
            startActivity(intent)
        }

        //Para elegir de que manera (vertical, horiz. etc) queremos mostrar los recyclerview
        publisherRecyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

        username = findViewById(R.id.usernameTV)
        logoutBtn = findViewById(R.id.logoutBtn)
//metodo para salir de la activity y borrar las flags de logged para volver a pedir login
        logoutBtn.setOnClickListener{
            val editor = sharedPreferences.edit()
            //aqui se quita el estatus de loggeado
            editor.remove("isLogged")
            editor.apply()
//esto es para volver al login
            val intent = Intent(this@PublisherActivity,MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

    }
