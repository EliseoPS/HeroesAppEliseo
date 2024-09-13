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

            if(email.isEmpty() || password.isEmpty()){
                Log.i("ERROR","La constraseña o email estan vacios")
                return@setOnClickListener
            }
            val isValidUser = User.staticUsers.any {
                    user-> user.email == email && user.password == password
            }
            if (!isValidUser) {
                Log.i("ERROR","El correo o passwrd son incorrectos")
                return@setOnClickListener
            }
            val user = User.staticUsers.firstOrNull{
                it.email == email && it.password == password
            }

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