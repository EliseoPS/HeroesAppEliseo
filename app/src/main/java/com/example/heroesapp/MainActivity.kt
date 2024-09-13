package com.example.heroesapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.heroesapp.models.User
import com.example.heroesapp.ui.PublisherActivity

class MainActivity : AppCompatActivity() {
    lateinit var loginBtn : Button
    lateinit var emailEt : EditText
    lateinit var passwordEt : EditText
    val user = User.staticUsers

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val sharedPreferences = getSharedPreferences("mypref", MODE_PRIVATE)
        val isLogged = sharedPreferences.getBoolean("isLogged",false)
        val intent = Intent(this@MainActivity, PublisherActivity::class.java)

// Si el usuario ya está logueado, manda a PublisherActivity
        if(isLogged){
            startActivity(intent)
            finish()
        }

        loginBtn = findViewById(R.id.loginButton)
        emailEt = findViewById(R.id.etEmail)
        passwordEt = findViewById(R.id.etPassword)

        loginBtn.setOnClickListener{
            Log.i("LOGAPP","Iniciar Sesion")
            val email = emailEt.text.toString()
            val password = passwordEt.text.toString()
            Log.i("EMAIL",email)
            Log.i("PASSWORD", password)

// Verifica si email o password están vacíos
            if(email.isEmpty() || password.isEmpty()){
                Log.i("ERROR","La constraseña o email estan vacios")
                return@setOnClickListener
            }
            // Verifica si el usuario es válido
            val isValidUser = User.staticUsers.any {
                    user-> user.email == email && user.password == password
            }
            // si no es valido mandamos al logcat un error
            if (!isValidUser) {
                Log.i("ERROR","El correo o passwrd son incorrectos")
                return@setOnClickListener
            }
            //agarra el primer usuario que conicda y lo iguala a user
            val user = User.staticUsers.firstOrNull{
                it.email == email && it.password == password
            }
// Guarda el estado de inicio de sesión y el usuario en SharedPreferences
            //tambien su nombre para poder usarlo en otras activities
            val editor = sharedPreferences.edit()
            editor.putBoolean("isLogged",true)
            editor.putString("userEmail",user?.email)
            editor.putString("userName", user?.name)
            editor.apply()

            startActivity(intent)
            finish()

        }


    }
}