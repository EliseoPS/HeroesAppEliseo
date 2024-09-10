package com.example.heroesapp.models

data class User(val email : String, val password : String, val name : String){

    //    lo que este adentro no debes de crear una instancia para acceder
    companion object{
        val staticUsers = listOf(
            User(email="eliseo@gmail.com",password="12345","Eliseo"),
            User(email="max@gmail.com",password="54321","Max"),
            User(email="rafa@gmail.com",password="12345","Prime"),
            User(email="calatero@gmail.com",password="12345","Rafa")
        )
    }
}