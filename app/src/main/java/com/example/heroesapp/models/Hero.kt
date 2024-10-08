package com.example.heroesapp.models
//Campos de objeto heroe y su tipo de dato
data class Hero(val id : Int, val name : String, val image : String, val description : String, val publisherId : Int){

    companion object{
        val heroes = mutableListOf<Hero>(
            //Precarga de heroes con sus campos llenos
            Hero(
                1,
                "Spiderman",
                "https://media.vandal.net/i/1280x720/10-2023/17/202310171642263_5.jpg",
                "Peter Parker, es un adolecente que fue mordido por una araña radioactiva que le dio poderes increibles, es chavo cul.",
                1),
            Hero(
                2,
                "Iron Man",
                "https://www.latercera.com/resizer/v2/RKJGQU5T7RDCHPDKABKDBTPT54.jpg?quality=80&smart=true&auth=90d747ec2cf8467728219389dd7f0434e401aad1fa689b42bde71009a4e57fe0&width=690&height=502",
                "Tony Stark, un genio millonario, utiliza su intelecto y tecnología avanzada para crear la armadura de Iron Man y combatir el crimen.",
                1),
            Hero(
                3,
                "Captain America",
                "https://estaticos.elcolombiano.com/binrepository/580x872/0c10/580d365/none/11101/GBFJ/capitan-america_37326520_20210310181935.jpg",
                "Steve Rogers, el supersoldado con el escudo icónico, lidera a los Vengadores y representa los valores de justicia y libertad.",
                1),
            Hero(
                4,
                "Thor",
                "https://hips.hearstapps.com/hmg-prod/images/chris-hemsworth-thor-1623742528.jpeg",
                "El dios del trueno, hijo de Odín, lucha para proteger tanto a la Tierra como a Asgard con su martillo Mjolnir.",
                1),
            Hero(
                5,
                "Hulk",
                "https://us-tuna-sounds-images.voicemod.net/dabd8c48-ec97-4a71-9971-00f5b3298681-1711181817109.png",
                "Bruce Banner, tras ser expuesto a radiación gamma, se transforma en el increíble Hulk cuando se enfurece, con fuerza y resistencia sobrehumanas.",
                1),
            Hero(
                6,
                "Superman",
                "https://steamuserimages-a.akamaihd.net/ugc/2545179974080860814/144A2049E86A9E29FA35C7F7535F47BFFB950F17/?imw=5000&imh=5000&ima=fit&impolicy=Letterbox&imcolor=%23000000&letterbox=false",
                "Kal-El, el último hijo de Krypton, lucha por la verdad y la justicia como el Hombre de Acero con habilidades sobrehumanas.",
                2),
            Hero(
                7,
                "Batman",
                "https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/47ed6547-a02c-4fce-9613-cefe4c3fd17b/dech4lt-087ecd78-51f4-4ecd-a7ff-d3bd6d9e7237.jpg?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7InBhdGgiOiJcL2ZcLzQ3ZWQ2NTQ3LWEwMmMtNGZjZS05NjEzLWNlZmU0YzNmZDE3YlwvZGVjaDRsdC0wODdlY2Q3OC01MWY0LTRlY2QtYTdmZi1kM2JkNmQ5ZTcyMzcuanBnIn1dXSwiYXVkIjpbInVybjpzZXJ2aWNlOmZpbGUuZG93bmxvYWQiXX0.7B3YLHC81-Urz68WfHPAbNFwu9G4nr7g7qQRNS5CnNw",
                "Bruce Wayne, un multimillonario con un pasado trágico, usa su intelecto y habilidades de detective para combatir el crimen en Gotham City.",
                2),
            Hero(
                8,
                "Wonder Woman",
                "https://phantom-marca-mx.unidadeditorial.es/d01b2c211447ba0cb080f0a9e0cc6e10/resize/828/f/jpg/mx/assets/multimedia/imagenes/2023/08/11/16917106843810.jpg",
                "Diana Prince, una amazona guerrera con habilidades extraordinarias, lucha por la paz y la justicia con su lazo de la verdad.",
                2),
            Hero(
                9,
                "Flash",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQXMB28joKNbDsRpIiGXZMTwoJ2k15Rw3y5RQ&s",
                "Barry Allen, el hombre más rápido del mundo, utiliza su velocidad para combatir villanos y corregir el curso del tiempo.",
                2),
            Hero(
                10,
                "Aquaman",
                "https://pm1.aminoapps.com/6203/01cf871791d485a1b7ef95f96e11b156d3bfa870_hq.jpg",
                "Arthur Curry, mitad humano y mitad atlante, es el rey de los océanos y protege tanto la superficie como las profundidades del mar.",
                2)
        )

    }
}