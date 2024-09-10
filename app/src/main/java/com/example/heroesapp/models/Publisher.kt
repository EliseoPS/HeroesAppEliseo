package com.example.heroesapp.models

data class Publisher(val id : Int, val name : String, val image : String){

    companion object{
        val publishers = mutableListOf<Publisher>(
            Publisher(id = 1, name = "Marvel","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSScUEKMGSoL-pFnlZj0S8JS_cDqTsUVL7i-A&s"),
            Publisher(id =2, name = "DC","https://upload.wikimedia.org/wikipedia/commons/thumb/1/1c/DC_Comics_logo.png/768px-DC_Comics_logo.png")
        )
    }
}